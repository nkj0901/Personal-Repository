# Module 1 - Create a BlockChain

# To be installed:
# Flask==0.12.2: pip install Flask==0.12.2
# Postman HTTP Client: https://www.getpostman.com/

# Importing the libraries
import datetime
import hashlib
import json
from flask import Flask, jsonify

# Part 1 - Building a Blockchain

class Blockchain:
    def __init__(self): #블록체인 초기화
        #새로운 변수를 삽입
        #selfchain은 다른 블록을 포함하는 리스트가 됨
        self.chain = []
        #제네시스 블록 생성
        self.create_block(proof = 1, previous_hash = '0')
        
    # 함수에 대한 인수 정의
    def create_block(self, proof, previous_hash):
        #역할 정의
        block = {'index': len(self.chain) + 1,
                 # json 형식으로 작업할 때 형식 문제가 발생할 수 있기 때문에 str로 바꿔줌
                 'timestamp': str(datetime.datetime.now()), 
                 'proof': proof,
                 'previous_hash': previous_hash}
        self.chain.append(block) #블록체인에 추가하기
        return block

    def get_previous_block(self):
        return self.chain[-1]
    
    def proof_of_work(self, previous_proof):
        new_proof = 1
        check_proof = False;
        while check_proof is False:
            #아래에서 +연산을 사용하면 연산이 대칭이 된다. 두 숫자의 자리를 바꾸어도 값이 같음
            #어느 시점에 신규 증명이 곧 과거의 이전 증명이 된다. 그렇기 때문에 -연산을 사용
            #어려운 연산을 만들기 위해 제곱 연산을 추가한다.
            #SHA256에 맞는 형식으로 바꾸기 위해 str, .encode()를 추가한다. .encode는 앞에 b를 붙인다.
            #우리는 16진수를 사용해야 하니까 .hexdigest를 뒤에 추가해준다.
            hash_operation = hashlib.sha256(str(new_proof**2 - previous_proof**2).encode()).hexdigest()
            #hash 연산이 선행 제로 4개로 시작하는지 확인
            if hash_operation[:4] == '0000':
                check_proof = True
            else:
                new_proof += 1
        return new_proof
    
    #블록을 입력 값으로 갖고 해당 블록에 대한 SHA 암호화 해시를 그 결과로 반환
    def hash(self, block):
        #딕셔너리를 문자열로 바꾸는 작업이 필요 - 문자열을 생성하는 dumps 함수 이용
        #두 개의 인자가 들어감(블록, 키별로 정렬할 수 있도록 만드는 변수 sort_keys=true)
        #.encode를 붙이면 인코딩된 블록이 만들어진다.(hashlib SHA256 함수에서 예상하는 형식)
        encoded_block = json.dumps(block, sort_keys = True).encode()
        return hashlib.sha256(encoded_block).hexdigest()
    
    def is_chain_valid(self, chain):
        previous_block = chain[0]
        block_index = 1
        while block_index < len(chain):
            block = chain[block_index]
            if block['previous_hash'] != self.hash(previous_block):
               return False
            #이전 블록의 증명과 현재 블록의 증명 간 해시 연산을 산출할 것이다.
            #연산의 결과의 선행 제로가 4개로 시작하는지 확인
            previous_proof = previous_block['proof']
            proof = block['proof']
            hash_operation = hashlib.sha256(str(proof**2 - previous_proof**2).encode()).hexdigest()
            if hash_operation[:4] != '0000':
               return False
            #지금 보고있는 블럭을 이전 블럭으로 설정해주기
            previous_block = block
            block_index += 1
        return True
    
  
# Part 2 - Mining our Blockchain

# Creating a Web App
app = Flask(__name__) 

# Creating a Blockchain
blockchain = Blockchain()

# Mining a new block    
# 블록 채굴에 쓰이는 메서드
#채굴은 어떻게 했더라? 이전 증명을 기반으로 증명을 찾아서 작업증명 문제를 해결
@app.route('/mine_block', methods = ['GET']) #데코레이터
def mind_block():
    previous_block = blockchain.get_previous_block()
    previous_proof = previous_block['proof']
    proof = blockchain.proof_of_work(previous_proof) 
    previous_hash = blockchain.hash(previous_block)
    block = blockchain.create_block(proof, previous_hash)
    response = {'message' : 'Congratulations, you jush mined a block',
                'index' : block['index'],
                'timestamp' : block['timestamp'],
                'proof' : block['proof'],
                'previous_hash' : block['previous_hash']}
    return jsonify(response), 200 #json 형식으로 반환
   
# Getting the full Blockchain
#전체 블록을 가지고 오는 메서드
@app.route('/get_chain', methods = ['GET']) #데코레이터
def get_chain():
    response = {'chain' : blockchain.chain,
                'length' : len(blockchain.chain)}
    return jsonify(response), 200 #json 형식으로 반환 

# Checking if the Blockchain is valid
@app.route('/is_valid', methods = ['GET']) #데코레이터
def is_valid():
       is_valid = blockchain.is_chain_valid(blockchain.chain)
       if is_valid:
           response = {'message' : 'All good. the blockchain is valid'}
       else:
           response = {'message' : 'KIJUNG, we have a problem'}
       return jsonify(response), 200
           

# Running the app
app.run(host = '0.0.0.0', port = 5000)