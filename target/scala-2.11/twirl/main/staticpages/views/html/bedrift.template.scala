
package staticpages.views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object bedrift extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<div >
    <div class="container">
        <div class="row space-above space-below">
            <div class="col-md-10 col-md-offset-1 transparent-box rounded">
                <div class="text-center">
                    <h1>Bedrift</h1>
                </div>
                <div class="paragraph">
                    <h2>Bedriftskontakt</h2>

                    <!--"""),_display_(/*11.26*/if(!models.LoginState.isValidlyLoggedIn)/*11.66*/ {_display_(Seq[Any](format.raw/*11.68*/("""<p>Dette er en test</p>""")))}/*11.93*/else/*11.97*/{_display_(Seq[Any](format.raw/*11.98*/("""<p>Dette er ikke en test</p>""")))}),format.raw/*11.127*/("""-->

                    <p>
                        <strong>Hybridas Bedriftskomite (Hybrida BedKom) har ansvaret for kontakten med bedriftene for sivilingeniørstudiet Ingeniørvitenskap og IKT (I & IKT) ved NTNU. Vi ble etablert for å gi bedrifter informasjon om vårt studieprogram og hvilken kompetanse vi kan bidra med.</strong></p>
                    <p>
                        Hovedmålet vårt er at vi vil hjelpe studentene på linja med prosjektoppgaver, hovedoppgaver, sommerjobber og fast ansettelse. I tillegg kan bedriftsbesøk, ekskursjoner og temakvelder gi bedrifter og studenter mulighet til å snakke sammen.</p>
                    <p>
                        Arrangementer av denne typen krever samarbeid fra bedrifter. Hvis du kan bidra, kontakt oss gjerne via linken i menyen venstre. For en komplett liste med Hybrida Bedkoms oppgaver og gjøremål, se våre statutter i samme meny.</p>
                    <h2>Bedriftsbesøk:</h2>
                    <p>
                        Et bedriftsbesøk går i hovedsak ut på at bedriften besøker NTNU for å presentere seg for studentene. Et typisk bedriftsbesøk innebærer først og fremst en presentasjon der bedriften holder foredrag for utvalgte studenter. I tillegg er det vanlig med påfølgende bespisning, og mange bedrifter velger å ha jobbsamtaler/intervjuer tilknyttet besøket.</p>
                    <p>
                        Hensikten er vanligvis først og fremst rekruttering, men et bedriftsbesøk gir også god markedsføring mot kommende sivilingeniører. Hybrida BedKom tar seg av all praktisk organisering dere trenger kun å møte opp forberedt med presentasjon!</p>
                    <h2>Presentasjon:</h2>
                    <p>
                        Presentasjonen varer vanligvis i én skoletime (45 minutter) og avholdes oftest i auditorium. Her er de fleste audiovisuelle hjelpemidler tilgjengelig (PC/projektor, mikrofoner, overhead osv), og dersom dere har spesielle ønsker vil vi selvsagt forsøke å etterkomme disse. De fleste presentasjoner begynner 17:15 eller 18:15, da dette passer godt med timeplanen til studentene.</p>
                    <h2>Bespisning:</h2>
                    <p>
                        De aller fleste bedrifter velger å spandere mat og drikke etter presentasjonen. Her har vi flere samarbeidspartnere og kan blant annet tilby rimelige alternativer fra SiT (Studentsamskipnaden i Trondheim), som holder til på Gløshaugen. Noen bedrifter ønsker fri bar, andre vil ha et fast antall enheter i form av drikkebonger. Bespisningen gir bedriften en fin mulighet til å snakke direkte med studentene i uformelle omgivelser. Det er ofte i den forbindelse interesserte melder seg på til jobbsamtaler.</p>
                    <h2>Tips:</h2>
                    <p>
                        Dette er tips basert på tilbakemeldinger vi har fått fra studenter over flere år:
                    </p>
                    <ul>
                        <li>
                            Husk at dere snakker for I &amp; IKT-studenter. Ikke vær redd for å bruke fagbegreper de burde kjenne til.
                        </li>
                        <li>
                            Forsøk å skille dere ut fra andre bedrifter hva er det som gjør nettopp dere til den mest attraktive arbeidsgiveren?
                        </li>
                        <li>
                            Fokuser på hvordan det er å arbeide i deres bedrift sosialt, arbeidsoppgaver, arbeidsmiljø, utfordringer. Vis gjerne bilder fra arbeidsplassen.
                        </li>
                        <li>
                            Organisasjonsinndeling, økonomi og administrasjon er ofte mindre interessant når det kommer til å velge jobb. Forsøk å legg mindre vekt på dette enn de overnevnte punkter.
                        </li>
                        <li>
                            Begrens presentasjonen til 45 minutter.
                        </li>
                        <li>
                            Ta med en nyutdannet sivilingeniør fra NTNU, samt en fra HR.
                        </li>
                        <li>
                            Still med flere personer, slik at det er enklere å komme i kontakt med dere under bespisningen.
                        </li>
                    </ul>
                    <h2>Priser:</h2>
                    <p>
                        Hybrida BedKom tar et honorar på kroner 8 000,- for en bedriftspresentasjon som holdes for alle klassetrinn ved studiet (opptil 70 personer). Dette inkluderer PR-kostnader og liknende. Mat og drikke kommer i tillegg. Priser fra ulike leverandører fåes ved forespørsel. Hvis bedriften ønsker en presentasjon for mindre grupper innenfor I & IKT (typisk en av spesialiseringene), kan dette selvsagt ordnes etter avtale. Slike arrangement tar vi selvsagt et lavere honorar for.
                    </p>
                </div>
                <div>
            </div>
            </div>
        </div>

    </div>
</div>
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/staticpages/views/bedrift.scala.html
                  HASH: 38afc22edc6db0b209fc1f0ff6e18124b091f57d
                  MATRIX: 812->0|1223->384|1272->424|1312->426|1355->451|1368->455|1407->456|1468->485
                  LINES: 29->1|39->11|39->11|39->11|39->11|39->11|39->11|39->11
                  -- GENERATED --
              */
          