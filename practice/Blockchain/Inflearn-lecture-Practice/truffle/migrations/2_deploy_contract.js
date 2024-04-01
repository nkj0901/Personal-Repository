var MyContract = artifacts.require("./MyContract.sol"); //MyContract 파일을 가지고 온다.

module.exports = function(deployer) { //deployer은 truffle이 제공하는 것이다.
    deployer.deploy(MyContract); //배포
};
