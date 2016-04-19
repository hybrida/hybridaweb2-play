
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
object jentekom extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<div class="article-bg" style="background-image: url('"""),_display_(/*1.56*/routes/*1.62*/.Assets.at("images/bakgrunnsbilde_roser.jpg")),format.raw/*1.107*/("""')">
    <div class="container">
        <div class="row space-above space-below">
            <!-- <p><img src="/assets/images/jentekom_bilde.jpg"></p> -->
            <div class="col-md-6 col-md-offset-5 transparent-box rounded">
                <div class="text-center">
                    <h1>JenteKom</h1>
                </div>
                <div class="paragraph">
                    <h2>Hybrida Jentekomité</h2>
                    <p>
                        <strong>Hybridas Jentekomité er en av komitéene til linjeforeningen Hybrida, og er ansvarlig for organisering, planlegging og gjennomføring av sosiale og faglige arrangementer for jentene på linjen.</strong></p>
                    <p>
                        Jentekomitéen ble opprettet fordi det var et stort mindretall av jenter på linjen vår. Formålet var å skape et samhold mellom jentene på tvers av alle trinnene, slik at disse kan utveksle erfaringer. Dette har ført til et bra jentemiljø. Etter at Jentekom ble opprettet har færre sluttet og det er blitt flere kvinnelige søkere. Dette har resultert i at vi nå er 58 jenter på linja, noe som tilsvarer 26 % totalt (høsten 2015). Vi er fortsatt i mindretall, men ser veldig positivt på andelen og fremgangen.
                    </p>
                    <p>
                        Jentekom består av 8 medlemmer, hvorav leder sitter i hovedstyret til Hybrida. Jentekom arrangerer forskjellige aktiviteter for jentene på I&IKT. Blant disse er det noen tradisjoner som avholdes hvert år. Blant disse arrangeres reke- og vinkveld i fadderperioden, tapaskveld med ingeniørspillet, cocktailaften og kafékvelder. Målet er å arrangere minst et faglig og et sosialt arrangement per semester.
                    </p>
                    <br>
                    <p>
                        Har du noe på hjertet, ikke nøl med å ta kontakt!
                    </p>
                    <p>
                        <strong>Jentekomitésjef</strong> Tonje Roås Mikalsen, tonjerm@stud.ntnu.no (2.kl.)</p>
                    <p>
                        <strong>Øvrige medlemmer:</strong> Tora S. Gunstad (1.kl.),<br>
                        Amalia Sambanis (1.kl.), <br>
                        Marianne Kalberg Wiggen (2.kl.), <br> Synne Hinna (2.kl.), <br>
                        Helene Dypbukt (3.kl.), <br> Marit Rakvåg (3.kl.), <br>
                        Karoline Louise Rykkelid (5.kl.)
                    </p>
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
                  DATE: Tue Apr 19 17:27:42 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/staticpages/views/jentekom.scala.html
                  HASH: addf6d07d9914e25baac2cf822fd951f75dd8b56
                  MATRIX: 813->0|894->55|908->61|974->106
                  LINES: 29->1|29->1|29->1|29->1
                  -- GENERATED --
              */
          