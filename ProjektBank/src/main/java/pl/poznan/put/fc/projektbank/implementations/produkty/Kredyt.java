/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.fc.projektbank.implementations.produkty;

import pl.poznan.put.fc.projektbank.implementations.operacje.SplataKredytu;
import pl.poznan.put.fc.projektbank.interfaces.OperacjaBankowa;
import pl.poznan.put.fc.projektbank.interfaces.SystemOdsetek;
import pl.poznan.put.fc.projektbank.interfaces.Visitable;

/**
 *
 * @author fenix
 */
public class Kredyt extends RachunekBankowy implements Visitable
{
    private final RachunekBankowy rachunek;

    public Kredyt(long id, SystemOdsetek systemOdsetek, RachunekBankowy rachunek) {
        super(id, systemOdsetek);
        this.rachunek = rachunek;
    }



    public RachunekBankowy getRachunekBankowy() {
        return rachunek;
    }

    public void zerwijKredyt() {
        OperacjaBankowa zerwanieKredytu = new SplataKredytu(this);
        zerwanieKredytu.wykonaj();
    }



	@Override
	public void Accept(Raport InVisitor)
	{
		InVisitor.Visit(this);
	}
}
