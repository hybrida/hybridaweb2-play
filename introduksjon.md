<script type="text/javascript" src="http://livejs.com/live.js"></script>

# Introduksjon til Webkom

Mye å sette seg inn i før man kan begynne å gjøre noe nyttig. Her skal jeg forsøke å gi en introduksjon som gjør dere i stand til å gjøre *noe* på egenhånd, samt mulig å finne ut av ting videre. Fokus i dag:

- Webprogrammering: hvordan forskjellige teknologier sammen gjør det mulig å lage en webapplikasjon
- Git: hvordan å jobbe sammen på kildekode
- Play Framework: hvordan vi skal gjøre dette

Dere er alle på forskjellig nivå. Sannsynligvis kommer du til å finne ting du synes er for enkelt, og noe du ikke skjønner noe av. Det er helt greit. Mye er nytt, og tanken er at du kan ha dette dokumentet å kikke tilbake på om det er noe du glømmer.

## Hvordan du får se noe når du går til hybrida.no

1. Jeg spør om hva som finnes på hybrida.no
2. DNS sender meg til serveren på NTNU
3. Serveren sender nettsida tilbake
4. Nettleseren viser HTML og CSS, og kjører javascript

## Git

Git er et kommandolinjeprogram. Det ser sånn ut i Windows:
![Git i kommandolinja](http://msysgit.github.io/img/gw1.png "Kommandolinja")

Filtilstander:

![Status på filer (lokalt)](http://git-scm.com/figures/18333fig0201-tn.png)

### Hvorfor git?

"Vi kunne jo hatt filene i Dropbox, og det er jo mye enklere!"

Koden var i Dropbox før. Problemer vi får da, er at

- Når noen har gjort en feil, får *ingen* testa koden
- Når to personer redigerer samme fil, er det helt tilfeldig hva som kommer med videre
- Git er mye bedre på filhistorikk -- La oss ta et eksempel. Du koder av gårde, og lager en løsning som funker, men er stygg som bare. En god programmerer som du er, setter du igang med gjenopprette orden. Så finner du ut at alle endringene du gjorde bare var tull, og vil tilbake til originalen. I Dropbox må du da se gjennom alle versjonene av filene, og hente ut den du trenger. Dette må du inn på nettsida til Dropbox for å gjøre. I git trenger du bare finnne endringen (arbeidsbiten) med det passende navnet.

### Nyttige kommandoer

- `git clone git@github.com:hybrida/hybridaweb2-play.git`: Last ned prosjektet fra github til mappa du er i
- `git add teodor-hallo.txt`: Si at teodor-hallo.txt skal "være med", dette er en fil jeg vil dele med andre
- `git commit -m "Hallo i teodor.txt"`: Lag en ny "arbeidsbit"
- `git push`: Last opp nye "arbeidsbiter" så andre kan få tak i dem
- `git pull`: Hent "arbeidsbiter" fra de andre

## Play framework

### Hvorfor ikke rein java?

Å programmere en nettapplikasjon er en *veldig* vanlig oppgave. Her må man håntere url-er som kommer inn, snakke med en database, og sende tilbake HTML. HTML-en refererer til CSS som beskriver stil, og Javascript som skal kjøres på klienten når sida kommer fram. Disse oppgavene gjør Play (og andre rammeverk) godt. Eksempel: routes, som definerer hvilke URL-er som blir til hvilke funksjonskall.

### Hvordan å sette opp hybridaweb lokalt?

Først må du vise github hvem du er. Dette gjør du ved å lage to nøkler. Den ene (privat) bekrefter at du er deg. Den andre (offenlig) er en slags signatur. Tenkt på det som en underskrift. Her er underskriften min (offentlig). Dersom jeg er i stand til å skrive denne (privat, bare du).

1. Lag nøkkelpar. Windows: åpne git bash og kjør `ssh-keygen`. Linux/mac: åpne en terminal og kjør `ssh-keygen`
2. Kopier innholdet til `.ssh/id_rsa.pub` til github-kontoen din.

Så skal vi sette laste ned filene.

1. Gå til mappa du vil lagre prosjektet i. Jeg bruker `C:/Users/Teodor/git` (Windows) eller ~/git (Linux).
2. Klon prosjektet: `git clone git@github.com:hybrida/hybridaweb2-play.git`
3. (Dersom du vil bruke et IDE) Generér filer som forteller IDE-et om hvor forskjellige ting ligger: `activator idea` (for Intellij IDEA)
4. Kompilér og kjør prosjektet: `activator run`

Nå kjører hybridaweb på pc-en din. Gå til `localhost:9000` i en nettleser for å se hva som dukker opp. Når du gjør endringer på koden, trenger du ikke gjøre noe annet enn å oppdatere, play kompilerer for deg.

Yes, så nå har vi sida oppe. Ikke vær redd for å gjøre ting feil, det tar vi som det kommer. Rydd opp etter deg, så er det ikke noe stress.
