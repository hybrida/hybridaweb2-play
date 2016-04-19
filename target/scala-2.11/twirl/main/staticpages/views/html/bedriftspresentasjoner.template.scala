
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
object bedriftspresentasjoner extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<div class="article-bg">
    <div class="container">
        <div class="row space-above"></div>
            <div class="row">
                <div class="col-md-10 col-md-offset-1 transparent-box rounded">
                    <div class="text-center" id='article-title'>
                        <h1 style="border-bottom: black solid 1px; display: inline-block; width: 350pt;">
                            Bedriftspresentasjoner
                        </h1>
                    </div>
                </div>
            </div>

        <div class="row space-above space-below">
            <div class="col-md-10 col-md-offset-1 transparent-box paragraph rounded">
                <div>


                    <h2 style="border-bottom: black dotted 1px; display: inline-block">
                        Om bedriftspresentasjoner
                    </h2>
                    <p>
                        <img align="right" alt="Det skal egentlig være et bilde her...lover....helt sant!" hspace="15" vspace="15" width="300" src=""""),_display_(/*23.150*/controllers/*23.161*/.routes.Assets.at("/images/IKT-ringen-2.jpg")),format.raw/*23.206*/("""">
                    </p>
                    <p>
                        En bedriftspresentasjon går i hovedsak ut på at bedriften besøker NTNU for å presentere seg for
                        studentene. Et slikt besøk innebærer først og fremst en presentasjon der bedriften holder
                        foredrag for utvalgte studenter. Det er også mulig å rette seg spesielt mot studenter fra en
                        gitt fordypning. I tillegg er det vanlig med påfølgende bespisning, og mange bedrifter velger
                        å ha jobbsamtaler/intervjuer tilknyttet besøket.

                    <p>
                        Hensikten er først og fremst rekruttering, men en bedriftspresentasjon gir også god
                        markedsføring mot kommende sivilingeniører. Hybrida Bedriftskomité tar seg av all praktisk
                        organisering, bedriften trenger kun å møte opp forberedt med en presentasjon.
                    </p>
                    <p>
                        Presentasjonen varer vanligvis i én forelesingstime (45 minutter) og avholdes oftest i
                        auditorium. Her er de fleste audiovisuelle hjelpemidler tilgjengelig (PC/projektor).
                        Dersom bedriften har spesielle ønsker vil vi selvsagt forsøke å etterkomme disse. De
                        fleste presentasjoner begynner 17:15 eller 18:15, da dette passer godt med timeplanen til studentene.
                    </p>

                    <h2 style="border-bottom: black dotted 1px; display: inline-block">
                        Bespisning
                    </h2>
                    <p>
                        <img align="right" alt="Det skal egentlig være et bilde her...lover....helt sant!" hspace="15" vspace="15" width="300" src=""""),_display_(/*48.150*/controllers/*48.161*/.routes.Assets.at("/images/IKT-ringen-5.jpg")),format.raw/*48.206*/("""">
                    </p>
                    <p>
                        De aller fleste bedrifter velger å spandere mat og drikke etter presentasjonen. Her har vi flere
                        samarbeidspartnere og kan blant annet tilby rimelige alternativer fra SiT (Studentsamskipnaden i
                        Trondheim), som holder til på Gløshaugen. I tillegg til SiT er også serveringsalternativer ved
                        restauranter i Trondheim sentrum aktuelle. Restauranter er ikke nøvdendigvis dyrere enn SiT.
                    </p>

                    <p>
                        Noen bedrifter ønsker fri bar, andre vil ha et fast antall enheter i form av drikkebonger.
                        Bespisningen gir bedriften en fin mulighet til å snakke direkte med studentene i uformelle
                        omgivelser. Det er ofte i den forbindelse interesserte melder seg til jobbsamtaler.
                    </p>


                    <h2 style="border-bottom: black dotted 1px; display: inline-block">
                        Kostnader ved bedriftspresentasjon
                    </h2>
                    <p>
                        Fast honorar til Hybrida Bedriftskomité som arrangør, er 150 kr per besøkende gjest,
                        honorargrensen er på 10 000 kr. Dette betyr at Hybrida Bedriftskomité ikke kommer til å kreve mer
                        enn 10 000 kr totalt i honorar for et arrangement, uavhengig om antall besøkende tilsier mer.
                        Dette honoraret er bidrag til Hybrida som går til studentene på I&IKT.
                    </p>
                    <p>
                        For medlemmer av I&IKT-ringen følger det derimot rabatter ved bedriftspresentasjoner med i
                        medlemskapet. Rabattene inluderer 25 % avslag på honoraret, i tilegg til 25 % på maksimalt honorar.
                        Dette tilsier 112,50 kr per besøkende gjest, og maksimalt 7500 kr.
                    </p>
                    <p>
                        Kostnader knyttet til mat og drikke på serveringsstedet kommer i tillegg til honoraret.
                        Oppdaterte menyer og priser for ulike serveringssteder kan fåes av Hybrida Bedriftskomité på
                        forespørsel, da de hele tiden er utsatt for endringer.
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
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/staticpages/views/bedriftspresentasjoner.scala.html
                  HASH: dd2f0bc886ebb269cc3f296e1e53f0c7877c4248
                  MATRIX: 827->0|1903->1048|1924->1059|1991->1104|3840->2925|3861->2936|3928->2981
                  LINES: 29->1|51->23|51->23|51->23|76->48|76->48|76->48
                  -- GENERATED --
              */
          