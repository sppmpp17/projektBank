/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.fc.projektbank.implementations;

import java.util.HashMap;
import java.util.Map;

import pl.poznan.put.fc.projektbank.implementations.produkty.RachunekBankowy;

/**
 *
 * @author fenix
 */
public class Bank {
    private Map<Long, RachunekBankowy> RachunkiBankowe=new HashMap<Long, RachunekBankowy>();
	private int BankID;
	private KIR KrajowaIzbaRozliczeniowa;

	public Bank(int InBankID, KIR InKrajowaIzbaRozliczeniowa)
	{
		BankID = InBankID;
		KrajowaIzbaRozliczeniowa = InKrajowaIzbaRozliczeniowa;
		KrajowaIzbaRozliczeniowa.DodajBank(BankID, this);
	}

	public void DodajRachunekBankowy(RachunekBankowy InRachunekBankowy)
	{
		RachunkiBankowe.put(InRachunekBankowy.GetNumerRachunku(), InRachunekBankowy);
	}

	public int GetBankID()
	{
		return BankID;
	}
	
	public RachunekBankowy GetRachunekBankowy(Long InNumerRachunkuBankowego)
	{
		return RachunkiBankowe.get(InNumerRachunkuBankowego);
	}
}
