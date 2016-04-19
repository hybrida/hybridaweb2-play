
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
object ringen extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<nav class="transparent-box" id="sidebar">
    <ul class="nav nav-pills nav-stacked">
        <li><a class="page-link" href="#1">IKT-Ringen</a></li>
        <li><a class="page-link" href="#2">Hva er I&IKT Ringen?:</a></li>
        <li>
            <a class="page-link" href="#3">Medlemmer</a>
            <ul class="nav nav-pills nav-stacked sub-nav">
                <li><a href="http://www.kbedesign.com/" target="_blank">Aker Solutions KBe Design</a></li>
                <li><a href="http://www.focus.no/" target="_blank"> Focus Software AS </a></li>
                <li><a href="http://www.nkgs.no/" target="_blank"> Norkart AS </a></li>
                <li><a href="http://www.anko.no/" target="_blank"> Anko AS </a></li>
            </ul>
        </li>
        <li>
            <a class="page-link" href="#4">Promotering</a>
            <ul class="nav nav-pills nav-stacked sub-nav">
                <li><a href=""""),_display_(/*17.31*/staticpages/*17.42*/.routes.Ringen.bedriftspresentasjoner()),format.raw/*17.81*/("""">Bedriftspresentasjon</a></li>
                <li><a href=""""),_display_(/*18.31*/staticpages/*18.42*/.routes.Ringen.ekskursjoner()),format.raw/*18.71*/("""">Ekskursjoner</a></li>
            </ul>
        </li>
        <li>
            <a class="page-link" href="#5">I&IKT Studentene</a>
            <ul class="nav nav-pills nav-stacked sub-nav">
                <li><a href="https://www.ntnu.no/studier/mting/oppbygning/geomatikk" target="_blank">Geomatikk</a></li>
                <li><a href="https://www.ntnu.no/studier/mting/oppbygning/konstruksjonsteknikk" target="_blank">IKT og konstruksjonsteknikk</a></li>
                <li><a href="https://www.ntnu.no/studier/mting/oppbygning/marinteknikk" target="_blank">IKT og Marin teknikk</a></li>
                <li><a href="https://www.ntnu.no/studier/mting/oppbygning/petroleumsfag" target="_blank">IKT og Petroleumsfag</a></li>
                <li><a href="https://www.ntnu.no/studier/mting/oppbygning/produktprosess" target="_blank">IKT, produktutvikling og materialer</a></li>
                <li><a href="http://www.ntnu.no/studier/mting/ikt-produksjonsledelse" target="_blank">IKT og produksjonsledelse</a></li>
            </ul>
        </li>
        <li><a class="page-link" href="#6">Bedriftens bidrag</a></li>
        <li>
            <a class="page-link" href="#7">Kontaktinformasjon</a>
            <ul class="nav nav-pills nav-stacked sub-nav">
            </ul>
        </li>
    </ul>
</nav>

<div class="pages">
    <section id="IKT-Ringen">
        <a href="#" name="IKT-Ringen"></a>
        <div id="infofoiler">

            <div id="IKT-Banner" >
                <img src=""""),_display_(/*47.28*/controllers/*47.39*/.routes.Assets.at("/images/bannerIKT.png")),format.raw/*47.81*/("""" />
            </div>
            <p id="ringeninfo">
                <b>I&IKT-ringen</b> skal gjøre studiet I&IKT bedre og sørge for en fremdeles sterk rekruttering av høy kvalitet til studiet og næringslivet.
                Dette gjøres ved å hindre frafall og ved å holde karaktersnittet for opptaksstudenter på et høyt nivå.
                Med bakgrunn i finansiering fra I&IKT-ringen og målrettede handlinger fra styret i samarbeidet med
                innspill fra medlemmene skal dette bli en realitet.
                Medlemsbedriftene får en eksklusiv mulighet til å promotere seg ovenfor,
                og rekruttere studenter med bakgrunn fra tradisjonell ingeniørvitenskap med kunnskaper innenfor IKT.
            </p>

        </div>
    </section>

    <section id="omIKT-Ringen">
        <div id="omikt">
            <a href="#" name="omIKT-Ringen"></a>
            <a class="link" href=""""),_display_(/*64.36*/staticpages/*64.47*/.routes.Ringen.about()),format.raw/*64.69*/("""">
                <p id="bedbidragoverskrift">
                    <b>Om IKT-Ringen</b>
                </p>
            </a>
        </div>
    </section>

    <section id="Medlemmene">
        <div id="Medlemmene">
            <a href="#" name="Medlemmene">
                <h2 class="bildetekst"> Medlemmene i IKT-Ringen </h2>
            </a>
        </div>
    </section>

    <section id="Promotering">
        <div id="promotering">
            <a href="#" name="Promotering"></a>
                <div class="bildetekst">Promoteringsmetoder</div>
            </div>
    </section>

    <section id="Studentene">
        <div id="studentene">
            <a href="#" name="Studentene"></a>
            <div class="container">
                <div class="row space-above space-below">
                    <div class="col-md-10 transparent-box paragraph rounded">
                        <div>
                            <h1> I&IKT Studendene</h1><br>
                            <p>
                                Ingeniørvitenskap og IKT (I&IKT) er en unik og tverrfaglig sivilingeniørutdannelse som utdanner
                                studenter med kompetanse innen både IKT og tradisjonelle ingeniørfag. Linjen ble opprettet på
                                bakgrunn av en undersøkelse i næringslivet, som viste at det var behov for ingeniører som kan kombinere
                                datatekniske og ingeniørfaglige kunnskaper på en helhetlig måte.<br><br>

                                De to første årene får studentene en grunnleggende kompetanse innen emner som IKT, matematikk, fysikk
                                og mekanikk. IKT-fagene, som innebærer blant annet programmering og systemutvikling, skal sørge for
                                at studenten skal inneha den samme kunnskapen som studenter ved rene IKT-linjer. Studenten vil også
                                ha mange klassiske ingeniørfag som man bygger videre på senere i studiet.<br><br>

                                I 3. klasse velger man spesialisering, og studenten velger da mellom fem retninger; geomatikk,
                                konstruksjonsteknikk, petroleumsfag, produkt og prosess eller marin teknikk. Studenten vil da følge
                                det faglige løpet ved den respektive spesialiseringen, samtidig som man fortsetter med IKT-fag og
                                fordyper seg ytterligere innen dette. Som ferdig utdannet ved I&IKT vil studenten ta med seg kompetanse
                                innen to fagfelt, og i tillegg ha evnen til å kombinere disse aktivt.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section id="BedriftensBidrag">
        <div id="infofoiler">
            <p id="bedbidragoverskrift">
            <b>Bedriftens bidrag</b>
            </p>

            <p id="bedbidraginfo">
               Bedriften bidrar med en årlig medlemskapsavgift gjennom sitt medlemskap i I&IKT-ringen.
                Styret i I&IKT-ringen ivaretar inntektene fra avgiften og disse pengene brukes til å forbedre
                studieprogrammet I&IKT. Denne medlemskapsavgiften avhenger selvsagt av bedriftens størrelse.
                En oversikt over bidraget fra hver størrelsesgruppe finnes i tabellen under.
            </p>

            <div id="medlemsprisbilde" >
                <img src=""""),_display_(/*132.28*/controllers/*132.39*/.routes.Assets.at("/images/medlemspris.png")),format.raw/*132.83*/("""" />
            </div>

            <p id="ringeninfo">
                 Et samarbeid gjennom I&IKT-ringen vil være avtalefestet gjennom en
                samarbeidsavtale som oppsummerer forpliktelsene til alle parter i samarbeidet.
            </p>
        </div>
    </section>
k.
    <section id="Kontaktinfo">
        <div id="kontakinfo">

            <p id="bedbidragoverskrift">
            <b>Kontaktinformasjon</b>
            </p>
            <p id="bedbidraginfo">I&IKT Styret er en samling av representanter fra NTNU og næringslivet, og er det overordnede organet i I&IKT-ringen</p>
            <div class="row">
                <div class="col-sm-4">
                    <b>Leder for I&IKT-ringen</b><br>Ola Westby<br>Mail: <a href="mailto:ola.westby@bntv.no?Subject=Hello%20again" target="_top">ola.westby@bntv.no</a><br><br>
                    <b>Studieprogramleder I&IKT</b><br>Terje Midtbø<br>Mail: <a href="mailto:terje.midtbo@ntnu.no?Subject=Hello%20again" target="_top">terje.midtbo@ntnu.no</a><br><br>
                   <br> <b>Studentrepresentanter fra NTNU</b><br>
                    Henrik Løfaldli<br>Mail: <a href="mailto:henrilof@stud.ntnu.no?Subject=Hello%20again" target="_top">henrilof@stud.ntnu.no</a><br><br>
                    Stephanie Buadu<br>Mail: <a href="mailto:stephabu@stud.ntnu.no?Subject=Hello%20again" target="_top">stephabu@stud.ntnu.no</a><br><br>
                </div>
                <div class="col-sm-4">
                    <b>Representanter fra NTNU</b><br>
                    Asbjørn Rolstadås<br>Mail: <a href="mailto:asbjorn.rolstadas@ntnu.no?Subject=Hello%20again" target="_top">asbjorn.rolstadas@ntnu.no</a><br><br>
                    Gunnhild Sekkenes Hatlen<br>Mail: <a href="mailto:gunnhild.hatlen@ntnu.no?Subject=Hello%20again" target="_top">gunnhild.hatlen@ntnu.no</a><br><br>
                    Jon Atle Gulla<br>Mail: <a href="mailto:jag@idi.ntnu.no?Subject=Hello%20again" target="_top">jag@idi.ntnu.no</a><br><br>
                    <b>Studentenes bedriftskontakt</b><br>
                    Hybrida Bedriftskomité v/ Bedriftskomitésjef Arnt Kristoffer Sørli
                    <br>Mail: <a href="mailto:hybrida-bedrift@list.stud.ntnu.no?Subject=Hello%20again" target="_top">hybrida-bedrift@list.stud.ntnu.no</a><br><br>


                </div>
                <div class="col-sm-4">
                    <b>Representanter fra næringslivet</b><br>
                    <b>Norkart AS: </b><br>Sverre Wisløff<br>Mail: <a href="mailto:sverre@norkart.no?Subject=Hello%20again" target="_top">sverre@norkart.no</a><br><br>
                    <b>Aker Solutions KBe Design: </b><br>Jon Østmoen<br>Mail: <a href="mailto:jon.ostmoen@akersolutions.com?Subject=Hello%20again" target="_top">jon.ostmoen@akersolutions.com</a><br><br>
                    <b>Focus Software AS: </b><br>Pål Eskerud<br>Mail: <a href="mailto:pe@focus.no?Subject=Hello%20again" target="_top">pe@focus.no</a><br><br>
                    <b>Anko AS:</b><br><br>Mail: <a href="mailto:@anko.no?Subject=Hello%20again" target="_top">@anko.no</a><br><br>
                </div>
            </div>


        </div>
    </section>

</div>

"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:37:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/staticpages/views/ringen.scala.html
                  HASH: bcd611f741a66beb5eb1749c6b8ee086e6376d0d
                  MATRIX: 811->0|1775->937|1795->948|1855->987|1945->1050|1965->1061|2015->1090|3565->2613|3585->2624|3648->2666|4603->3594|4623->3605|4666->3627|8221->7154|8242->7165|8308->7209
                  LINES: 29->1|45->17|45->17|45->17|46->18|46->18|46->18|75->47|75->47|75->47|92->64|92->64|92->64|160->132|160->132|160->132
                  -- GENERATED --
              */
          