package record;

public record BeneficiaryRecord(String name ,String accountNumber) {
	public boolean validate() {
		if(name!="James" && accountNumber!="424243443") {
			return false;
		}
		return true;
	}
}
