
package griffensorden.views.html

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
object griffensOrdenBody extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*2.1*/("""<div class="helesiden border">
    <div class="container">
        <div class="row blank"></div>
        <div class="row">
            <div class="col-md-6 col-md-offset-5 whitebox topright topleft GO">
                <img src="/assets/images/GO.png" align="middle">
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 col-md-offset-5 whitebox line">
                ________________________________________________________
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 col-md-offset-5 whitebox paragraph bottomleft bottomright hiddentopleft hiddentopright">
                <p>
                    <b>Griffens Orden</b> er en orden bestående av Hybrida-medlemmer som er tildelt en utmerkelse for deres arbeid for Hybrida eller studieprogrammet Ingeniørvitenskap og IKT. Alle medlemmene av denne ordenen har tittelen ”Ridder av Griffens Orden”, og for å få denne tildelt må medlemmet ha vist ekstraordinært engasjement og initiativ, og vist stor glede av å ytre Hybridas formål og verdier.
                </p>
                <p>
                    Utnevnelsen bestemmes av Vokterne av Griffens Orden. Dette er en komité på 8 Hybrida-medlemmer, bestående av minimum ett medlem fra hvert årskull. Vokterne er uavhengig av Hybridas styre, og står fritt til å tildele maks 3 utnevnelser hvert år. Ingen styremedlemmer fra Hybridas hovedstyre kan sitte i komitéen. Vokterne tar selv inn nye medlemmer når dette er nødvendig
                </p>
                <p>
                   Alle medlemmer av Hybrida kan være med å påvirke valgene gjort av vokterne. Medlemmer kan når som helst nominere andre medlemmer de mener fortjener utnevnelsen, basert på kriteriene beskrevet ovenfor. Nominasjoner gjøres her.  <a href="/griffensorden/nominasjon">(Anonym nominasjon)</a>
                </p>
                <p>
                    <a href="/griffensorden/riddere">Følgende medlemmer er tildelt Ridder av Griffens Orden</a>
                </p>
                </div>
            </div>
        </div>

    </div>
</div>
<div class="background">

</div>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/griffensorden/views/griffensOrdenBody.scala.html
                  HASH: d022d161d00a7987c4bc754e09bd21fdc47472d7
                  MATRIX: 824->2
                  LINES: 29->2
                  -- GENERATED --
              */
          