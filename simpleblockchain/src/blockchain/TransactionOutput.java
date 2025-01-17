package blockchain;

import java.security.PublicKey;

import blockchain.util.StringUtil;

public class TransactionOutput {
	public String id;
	public PublicKey reciepient; //also known as the new owner of these coins.
	public float value;
	public String parentTransactionId; //the id of the transaction this output was created in
	
	//Constructor
	public TransactionOutput(PublicKey reciepient, float value, String parentTransactionId) {
		this.reciepient = reciepient;
		this.value = value;
		this.parentTransactionId = parentTransactionId;
		this.id = StringUtil.applySha256(StringUtil.getStringFromKey(reciepient)+Float.toString(value)+parentTransactionId);
		
	}
	
	//Check if coin belongs to you
		public boolean isMine(PublicKey publicKey) {
			return (publicKey == reciepient);
	}
}
