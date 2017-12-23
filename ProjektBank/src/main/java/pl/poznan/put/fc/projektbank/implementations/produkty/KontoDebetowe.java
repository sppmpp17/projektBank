/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.fc.projektbank.implementations.produkty;

import pl.poznan.put.fc.projektbank.interfaces.OperacjaBankowa;
import pl.poznan.put.fc.projektbank.interfaces.Visitable;

/**
 *
 * @author inf83973
 */
public class KontoDebetowe extends AbstraktRachunekBankowyDekorator implements Visitable
{

    public KontoDebetowe(RachunekBankowy rachunek, double limit) {
        super(rachunek, limit);
    }

    @Override
    public void wykonajOperacje(OperacjaBankowa opracjaBankowa) {
        super.wykonajOperacje(opracjaBankowa);
    }

	@Override
	public void Accept(Raport InVisitor)
	{
		InVisitor.Visit(this);
	}
}
