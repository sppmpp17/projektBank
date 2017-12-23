package pl.poznan.put.fc.projektbank.implementations.produkty;

public class Raport
{
	public void Visit(RachunekBankowy InRachunekBankowy)
	{
		InRachunekBankowy.getStanRachunku();

		System.out.println("Utworzono raport - Rachunek Bankowy");
	}

	public void Visit(Kredyt InKredyt)
	{
		InKredyt.getStanRachunku();

		System.out.println("Utworzono raport - Kredyt");
	}

	public void Visit(KontoDebetowe InKontoDebetowe)
	{
		InKontoDebetowe.getStanRachunku();

		System.out.println("Utworzono raport - Debet");
	}
}
