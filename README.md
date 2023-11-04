# finboard

PASSWORD E NOME BACKEND HARDCODED, CAMBIARE!!!!!!!
isa-backend/src/main/resources/application.properties:
				spring.datasource.url=jdbc:mysql://localhost:3306/finboard
				spring.datasource.username=root
				spring.datasource.password=Password123#@!
				
----------------------------------FRONTEND--------------------------------------------------


Semplice applicazione che si interfaccia con il backend per recuperare i dati relativi 
ai bilanci e le analisi dei bilanci aziendali forniti.

Basato su Angular, non sono implementati i service per i componenti per la creazione
(inserimento in DB) di nuovi conti economico, stati patrimoniali e aziende.
Sono presenti i template.

L'applicazione permette di visualizzare (in maniera molto prototipale) dei grafi di 
confronto degli indici calcolati con le analisi.
E' possibile inoltre visualizzare i valori contenuti nei vari stati patrimoniali e 
dei conti economici



----------------------------------BACKEND---------------------------------------------------


REST API per il recupero delle informazioni relative ai documenti di bilancio delle
aziende contenute in un db mysql. 

Le analisi di bilancio sono fornite come oggetti tramite l'URL /analisi/...

SCHEMA E-R
			 1	     M
		AZIENDE <--------+---> CONTO ECONOMICO
  			 
			 1	    M
		AZIENDE <--------+--->STATO PATRIMONIALE
				 
API

  +-----+	
  | GET |
  +-----+

  
    • Analisi controller
           /analisi/{azienda}/{anno}
                → recupera l’analisi (composta da CE ed SP) relativa ad un’azienda specifica 
                e in merito ad un anno specifico 
	   /analisi/{azienda}
		→ recupera le analisi relative ad un’azienda di tutti gli ultimi 10 anni 		
		(se presenti)
	   /analisi/settore/nome/anno
		→ recupera tutte le analisi relative al settore di appartenenza 
		dell'azienda specificata (nome) rispetto ad un anno specificato (anno)  


    • Aziende controller
	   /aziende
		→ ritorna le aziende presenti nel DB
	   /aziende/{nome}
		→ ritorna l’azienda corrispondente a {nome}
	   /aziende/settore/{nome}
		→ ritorna tutte le aziende operanti nello stesso settore dell'azienda{nome}


    • ContoEconomico controller
           /contoeconomico
		→ ritorna tutti I conti economici 
	   /contoeconomico/today
		→ ritorna tutti I conti economici dell’anno corrente
	   /contoeconomico/dieci/{nome}
		→ ritorna tutti I conti economici degli utlimi dieci anni per l’azienda 		
		{nome}
	   /contoeconomico/today/{nome}
		→ ritorna il conto economico dell'anno corrente per l’azienda {nome}
	

    • StatoPatrimoniale controller
           /statopatrimoniale
              → ritorna tutti gli stati patrimoniali
           /statopatrimoniale/today
              → ritorna gli stati patrimoniali dell’anno corrente
           /statopatrimoniale/dieci/{nome}
              → ritorna tutti gli stati patrimoniali degli ultimi dieci anni di un’azienda 
              {nome}
           /statopatrimoniale/today/{nome}
              → ritorna lo stato patrimoniale dell'anno corrente per un’azienda {nome}
      
      
    • Home controller
	   /accesso 
		→ redirect to mock login page (grafica1/index)
		
	
	
  +--------+	
  | DELETE |
  +--------+	
  
  
      • Aziende controller
	   /aziende/{nome}
		→ ritorna l’azienda corrispondente a {nome}
      • Conto economico controller
	   /contoeconomico/{nome}/anno
		→ elimina il conto economico corrispondente a {nome} = nome azienda e {anno}
      • Stato patrimoniale controller
	   /statopatrimoniale/{nome}
		→ elimina lo stato patrimoniale corrispondente a {nome} = nome azienda e 
		{anno}
		
  +--------+	
  | POST   | TODO 
  +--------+
  
---------------------------------------------------------------------------------------------  
  
  

