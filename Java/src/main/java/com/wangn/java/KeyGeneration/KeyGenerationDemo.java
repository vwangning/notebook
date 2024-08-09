package com.wangn.java.KeyGeneration;
import com.webank.keygen.exception.KeyGenException;
import com.webank.keygen.model.PkeyInfo;
import com.webank.keygen.service.PkeyByRandomService;
import com.webank.keygen.service.PkeySM2ByRandomService;
import com.webank.keygen.utils.KeyPresenter;
public class KeyGenerationDemo {


    public static void main(String[] args) throws KeyGenException {


        //生成非国密私钥
        PkeyByRandomService eccService = new PkeyByRandomService();
        PkeyInfo eccKey = eccService.generatePrivateKey();
        System.out.println("private key:"+ KeyPresenter.asString(eccKey.getPrivateKey()));
        System.out.println("public key:" + KeyPresenter.asString(eccKey.getPublicKey().getPublicKey()));
        System.out.println("address:" +eccKey.getAddress());

        //生成国密私钥
        PkeySM2ByRandomService gmService = new PkeySM2ByRandomService();
        PkeyInfo gmPkey = gmService.generatePrivateKey();
        System.out.println("private key:"+ KeyPresenter.asString(gmPkey.getPrivateKey()));
        System.out.println("public key:" + KeyPresenter.asString(gmPkey.getPublicKey().getPublicKey()));
        System.out.println("address:" +gmPkey.getAddress());
    }
}