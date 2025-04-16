Esercizio 4: Pagamenti (esperto)

Obiettivo: Progettare un sistema di pagamento flessibile usando le interfacce.

Consegna:

    Crea un’interfaccia MetodoPagamento con:

        boolean paga(double importo)

    Implementa MetodoPagamento in:

        CartaDiCredito: saldo disponibile, paga solo se il saldo è sufficiente

        PayPal: funziona sempre (mock), stampa “Pagamento effettuato con PayPal”

    Crea una classe Carrello con metodo:

        void checkout(MetodoPagamento metodo, double importo)