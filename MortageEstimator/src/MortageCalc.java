
public class MortageCalc {
	
	public MortageCalc(){
		
	}
	
	

	public static double set18(double income){
		return (income/12)*.18;
	}
	
	public static double set36(double income, double debt){
		return ((income/12)*.36) - debt;
	}
	
	public static double setMaxPay(double income, double debt){
		double eighteen = MortageCalc.set18(income);
		double thirtysix = MortageCalc.set36(income, debt);
		if (eighteen < thirtysix){
			return eighteen;
		}
		else{
			return thirtysix;
		}
	}
	
	public static double calcFinance(double income, double interest, int term, double debt){
		double maxPay = MortageCalc.setMaxPay(income, debt);
		double periodicRate = interest/12/100;
		double A = (1 - Math.pow(1+periodicRate,-12*term))/periodicRate;
		double financeAmount = maxPay*A;
		return financeAmount;
	}
	
}
