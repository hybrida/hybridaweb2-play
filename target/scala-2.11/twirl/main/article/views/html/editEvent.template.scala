
package article.views.html

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
object editEvent extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Event,Article,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(event: Event, edarticle: Article):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.36*/("""
"""),format.raw/*2.1*/("""<div class="container-fluid center-container">
    <div class="row space-below">
        <div class="col-lg-8 space-above">
            <div class="transparent-box">
                <h3>Endre arrangement</h3>
                <form name="Article" action=""""),_display_(/*7.47*/article/*7.54*/.routes.Event.saveEdit(event.getId.toString)),format.raw/*7.98*/("""" method="POST" enctype="multipart/form-data">
                    """),_display_(/*8.22*/dependencies/*8.34*/.articleInputs(edarticle)),format.raw/*8.59*/("""
                    """),_display_(/*9.22*/dependencies/*9.34*/.eventInputs(event)),format.raw/*9.53*/("""
                    """),format.raw/*10.21*/("""<div class="form-group">
                        <input class="btn btn-primary form-control" type="submit" value="Post">
                    </div>
                    <div class="form-group">
                        <input class="btn btn-danger form-control" name="delete" type="submit" value="delete">
                    </div>
                </form>
            </div>
        </div>
        <div class="col-lg-4 space-above">
            <div class="transparent-box">
                <h3>Her skal det stå en del innformasjon om denne formen:</h3>
                <hr>
                <p>Det skal stå litt om hva de forskjellige feltene betyr, samt litt om hvordan vi liker å ha det her på hybridasiden!</p>
                <p>Før du oppretter ett nytt event eller en artikkel, ser vi gjerne at du leser igjennom disse retningslinjene
                    slik at vi får en kul side, med kule bilder, og kul formatering, som ser sinnsykt kul ut hele tiden, alltid!</p>
                <p><strong>Grensen står for klassetrinnet som har lov til å melde seg opp. Tallet står for avslutningsår.</strong></p>
            </div>
        </div>
    </div>
</div>"""))}
  }

  def render(event:Event,edarticle:Article): play.twirl.api.HtmlFormat.Appendable = apply(event,edarticle)

  def f:((Event,Article) => play.twirl.api.HtmlFormat.Appendable) = (event,edarticle) => apply(event,edarticle)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:40 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/article/views/editEvent.scala.html
                  HASH: acae7c6b96de7d91b21c04c75f160dad9089766a
                  MATRIX: 742->1|864->35|892->37|1178->297|1193->304|1257->348|1352->417|1372->429|1417->454|1466->477|1486->489|1525->508|1575->530
                  LINES: 26->1|29->1|30->2|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10
                  -- GENERATED --
              */
          