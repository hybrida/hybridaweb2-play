
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
object aboutRingen extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

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
                            Hva er I&IKT-Ringen?
                        </h1>
                    </div>
                </div>
            </div>

        <div class="row space-above space-below">
            <div class="col-md-10 col-md-offset-1 transparent-box paragraph rounded">
                <div>

                    <h2 style="border-bottom: black dotted 1px; display: inline-block">
                        I&IKT-ringen og partene i samarbeidet
                    </h2>
                    <p>
                        I&IKT-ringen er et samarbeidsforum med partene: linjeforeningen Hybrida ved Hybrida Bedriftskomité, fakultet for Ingeniørvitenskap og Teknologi og bedriftene som er medlemmer i samarbeidet. Formålet med samarbeidet er å tilby bedrifter helhetlig kontakt med studenter fra sivilingeniørstudiet Ingeniørvitenskap og IKT (I&IKT) ved NTNU og dets tilhørende fakultet.
                    <p>
                        <img align="right" alt="Det skal egentlig være et bilde her...lover....helt sant!" hspace="15" vspace="15" width="300" src=""""),_display_(/*24.150*/controllers/*24.161*/.routes.Assets.at("/images/IKT-ringen.jpg")),format.raw/*24.204*/("""">
                    </p>
                    <p>
                        Medlemskap i I&IKT-ringen gir bedriften mulighet til å komme med innspill til fakultetet om studieformen ved I&IKT, samtidig som bedriften oppnår fordeler med et slikt samarbeid med Hybridas Bedriftskomité. Blant disse fordelene er muligheten til å promotere seg særskilt ovenfor studenter på I&IKT.
                    </p>
                    <p>
                        Hybridas Bedriftskomité er en underkomité av linjeforeningen Hybrida. Komitéen har ansvaret for kontakten med bedrifter for I&IKT. Komitéen ble etablert for å opprette kontakt mellom studentene og bedrifter og gi bedrifter informasjon om hvilken kompetanse våre studenter innehar.
                    </p>
                    <p>
                        Hovedmålet til komitéen er å hjelpe studentene på linjen til prosjektoppgaver, hovedoppgaver, sommerjobber og fast ansettelse i samarbeid med bedrifter. I tillegg kan bedriftsbesøk, ekskursjoner og lignende som blir arrangert i samarbeid med komitéen gi bedrifter og studenter mulighet til å snakke sammen.
                    </p>

                    <h2 style="border-bottom: black dotted 1px; display: inline-block">
                        Om sivilingeniørstudiet Ingeniørvitenskap og IKT
                    </h2>
                    <p>
                        <img align="right" alt="Det skal egentlig være et bilde her...lover....helt sant!" hspace="15" vspace="15" width="300" src=""""),_display_(/*40.150*/controllers/*40.161*/.routes.Assets.at("/images/IKT-ringen-3.jpg")),format.raw/*40.206*/("""">
                    </p>
                    <p>
                        Hvor ofte har ikke et systemutviklingsprosjekt gått i vasken, fordi utviklerne ikke kjente behovene til fagspesialistene som skulle bruke systemet? Hvem har ikke latt seg fascinere av hvordan gode IKT-verktøy effektiviserer, visualiserer og videreutvikler tradisjonelle ingeniørmetoder?
                    </p>

                    <p>
                        I&IKT har som mål å utdanne sivilingeniører med en tverrfaglig kompetanse. Utvikling av fremtidens teknologi vil være avhengig av at vi kan utvikle nye IKT-løsninger som bruker ingeniørvitenskaplige metoder. Dette krever at man kan bygge bro mellom datatekniske og ingeniørfaglige utfordringer, og for å oppnå dette må man klare å ha oversikt over hele bildet.
                    </p>
                    <p>
                        Sivilingeniører fra Ingeniørvitenskap og IKT har den kunnskapen som kreves for å møte disse utfordringene, med solid kompetanse innen både den ingeniørfaglige og den datatekniske siden av sitt fagfelt. Studentene vil derfor kunne fylle rollen som fagspesialist og systemutvikler.
                    </p>

                    <h2 style="border-bottom: black dotted 1px; display: inline-block">
                        Oppbygningen av studiet
                    </h2>
                    <p>
                        Studieløpet ved I&IKT skiller seg fra andre sivilingeniørlinjer ved at den har et stort fokus på tverrfaglighet. I løpet av programmets to første år blir studentene introdusert for grunnleggende programmering og systemutvikling på lik linje med studenter fra rene IKT-rettede studieprogram. Samtidig blir studentene introdusert til ingeniørfag som mekanikk, fysikk og matematikk. Dette skal gi studentene en grundig innføring i fagområder knyttet til programmering, men samtidig et grunnlag til videre spesialisering og fordypning.
                    </p>
                    <p>
                        Etter fjerde semester velger studentene spesialisering blant Produkt og prosess, Marin teknikk, Konstruksjonsteknikk, Geomatikk og Petroleumsfag. Dette betyr i praksis at studenten følger det faglige løpet ved den respektive fordypningen, samtidig som man beholder en rekke IKT-fag ut studieløpet. Målet er at en student fra I&IKT skal gå ut med samme dybde i faget som studenter fra samme fagfelt og kunnskap tilsvarende en IKT-utdanning på universitetsnivå
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
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/staticpages/views/aboutRingen.scala.html
                  HASH: 58071413a87f27e4389417f178e929eb562338af
                  MATRIX: 816->0|2314->1470|2335->1481|2400->1524|3940->3036|3961->3047|4028->3092
                  LINES: 29->1|52->24|52->24|52->24|68->40|68->40|68->40
                  -- GENERATED --
              */
          