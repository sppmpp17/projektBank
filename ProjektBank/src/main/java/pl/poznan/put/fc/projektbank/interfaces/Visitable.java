package pl.poznan.put.fc.projektbank.interfaces;

import pl.poznan.put.fc.projektbank.implementations.produkty.Raport;

public interface Visitable
{
	public void Accept(Raport InVisitor);
}
