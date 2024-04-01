//모듈 import
const { WEB3Storage, Web3Storage } = require('web3.storage');
const dotenv = require('dotenv');
dotenv.config();

// Client(파일을 업로드하는 주체)
function makeStorageClient() {
    return new Web3Storage({token : process.env.WEB3Token});
}

// file 생성
function makeFileObjects(){
    const data = 'hello world';
    const buffer = Buffer.from(data);
    const file = [new File(buffer, 'newFile.json')];
    return file;
}

// IPFS 업로드
async function storeFile(){
    const client = makeStorageClient();
    const res = await client.put(makeFileObjects());
    console.log(res);
    // const files = await res.files();
    // for( const file of files){
    //     console.log(file);
    // }
}

storeFile();