
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
object viewArticle extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[models.Article,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(inarticle: models.Article):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.29*/("""
"""),_display_(/*2.2*/( /*This is for rendering a single article.*/ )),format.raw/*2.49*/("""

"""),format.raw/*4.1*/("""<div class="article-bg">
	<div class="container-fluid center-container">
		<div class="row space-below">
			<div class="col-xs-12 """),_display_(/*7.27*/if(models.LoginState.isValidlyLoggedIn)/*7.66*/{_display_(Seq[Any](format.raw/*7.67*/("""col-xl-7 """)))}),format.raw/*7.77*/("""space-above">
				<div class="white-box">
                    """),_display_(/*9.22*/dependencies/*9.34*/.articleSection(inarticle, inarticle)),format.raw/*9.71*/("""
                """),format.raw/*10.17*/("""</div>
            </div>
		    """),_display_(/*12.8*/if(models.LoginState.isValidlyLoggedIn)/*12.47*/{_display_(Seq[Any](format.raw/*12.48*/("""
				"""),format.raw/*13.5*/("""<div class="col-xs-12 col-xl-5 space-above">
                    """),_display_(/*14.22*/dependencies/*14.34*/.commentSection(inarticle)),format.raw/*14.60*/("""
                """),format.raw/*15.17*/("""</div>
            """)))}),format.raw/*16.14*/("""
        """),format.raw/*17.9*/("""</div>
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
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/article/views/viewArticle.scala.html
                  HASH: e930cdfcd637f1a909595dc0dc12fb29890b0e65
                  MATRIX: 745->1|860->28|888->31|955->78|985->82|1145->216|1192->255|1230->256|1270->266|1361->331|1381->343|1438->380|1484->398|1545->433|1593->472|1632->473|1665->479|1759->546|1780->558|1827->584|1873->602|1925->623|1962->633
                  LINES: 26->1|29->1|30->2|30->2|32->4|35->7|35->7|35->7|35->7|37->9|37->9|37->9|38->10|40->12|40->12|40->12|41->13|42->14|42->14|42->14|43->15|44->16|45->17
                  -- GENERATED --
              */
          