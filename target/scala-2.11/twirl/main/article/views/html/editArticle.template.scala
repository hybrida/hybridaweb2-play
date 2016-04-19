
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
object editArticle extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[models.Article,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(inarticle: models.Article):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*2.1*/("""<div class="container-fluid center-container">
    <div class="row space-below">
        <div class="col-lg-8 space-above">
            <div class="article_writer transparent-box">
                <h3>Endre artikkel</h3>
                <form name="Article" action=""""),_display_(/*7.47*/article/*7.54*/.routes.ArticleIn.saveEdit(inarticle.getId.toString)),format.raw/*7.106*/("""" method="POST" enctype="multipart/form-data">
                    """),_display_(/*8.22*/dependencies/*8.34*/.articleInputs(inarticle)),format.raw/*8.59*/("""
                    """),format.raw/*9.21*/("""<div class="form-group">
                        <input class="btn btn-primary form-control" type="submit" value="Post">
                    </div>
                    <div class="form-group">
                        <input class="btn btn-danger form-control" type="submit" name="delete" value="delete">
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
</div>
"""))}
  }

  def render(inarticle:models.Article): play.twirl.api.HtmlFormat.Appendable = apply(inarticle)

  def f:((models.Article) => play.twirl.api.HtmlFormat.Appendable) = (inarticle) => apply(inarticle)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:40 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/article/views/editArticle.scala.html
                  HASH: fd788c17e64b1f95f21beadcd590822087f64892
                  MATRIX: 745->1|860->28|888->30|1186->302|1201->309|1274->361|1369->430|1389->442|1434->467|1483->489
                  LINES: 26->1|29->1|30->2|35->7|35->7|35->7|36->8|36->8|36->8|37->9
                  -- GENERATED --
              */
          