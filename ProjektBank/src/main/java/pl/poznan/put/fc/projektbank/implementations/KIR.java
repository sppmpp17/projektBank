package pl.poznan.put.fc.projektbank.implementations;

import java.util.HashMap;
import java.util.Map;

import pl.poznan.put.fc.projektbank.implementations.operacje.Przelew;
import pl.poznan.put.fc.projektbank.implementations.produkty.RachunekBankowy;
import pl.poznan.put.fc.projektbank.interfaces.OperacjaBankowa;

public class KIR {
	private Map<Integer, Bank> RejestrBankow = new HashMap<Integer, Bank>();

	public KIR()
	{

	}

	public void DodajBank(int InBankID, Bank InBank)
	{
		RejestrBankow.put(InBankID, InBank);
	}

	public Boolean WykonajPrzelew(RachunekBankowy InRachunekBankowyNadawacy, int InBankIDOdbiorcy, long InNumerRachunkuOdbiorcy, double InWielkosc)
	{
		if(RejestrBankow.containsKey(InBankIDOdbiorcy))
		{
			OperacjaBankowa lPrzelew = new Przelew(InRachunekBankowyNadawacy, RejestrBankow.get(InBankIDOdbiorcy).GetRachunekBankowy(InNumerRachunkuOdbiorcy), InWielkosc);
			InRachunekBankowyNadawacy.wykonajOperacje(lPrzelew);

			return true;
		}

		return false;
	}
}
