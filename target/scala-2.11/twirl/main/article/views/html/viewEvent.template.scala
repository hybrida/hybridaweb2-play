
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
object viewEvent extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[models.Article,models.Event,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(inarticle: models.Article, event: models.Event):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.50*/("""
"""),_display_(/*2.2*/( /*This is for rendering a single event.*/ )),format.raw/*2.47*/("""

"""),format.raw/*4.1*/("""<div class="article-bg">
	<div class="container-fluid center-container">
		<div class="row space-below">
			<div class="col-xs-12 col-md-8 col-xl-7 space-above">
				<div class="white-box">
                    """),_display_(/*9.22*/dependencies/*9.34*/.articleSection(inarticle, event)),format.raw/*9.67*/("""
                    """),_display_(/*10.22*/dependencies/*10.34*/.attendingSection(event)),format.raw/*10.58*/("""
				"""),format.raw/*11.5*/("""</div>
            </div>
			<div class="col-xs-12 col-md-4 col-xl-5 space-above">
                """),_display_(/*14.18*/dependencies/*14.30*/.eventSidebar(event)),format.raw/*14.50*/("""
			"""),format.raw/*15.4*/("""</div>
            """),_display_(/*16.14*/if(models.LoginState.isValidlyLoggedIn)/*16.53*/ {_display_(Seq[Any](format.raw/*16.55*/("""
                """),format.raw/*17.17*/("""<div class="col-xs-12 col-xl-5 space-above">
                    """),_display_(/*18.22*/dependencies/*18.34*/.commentSection(inarticle)),format.raw/*18.60*/("""
                """),format.raw/*19.17*/("""</div>
            """)))}),format.raw/*20.14*/("""
		"""),format.raw/*21.3*/("""</div>
	</div>
</div>
"""))}
  }

  def render(inarticle:models.Article,event:models.Event): play.twirl.api.HtmlFormat.Appendable = apply(inarticle,event)

  def f:((models.Article,models.Event) => play.twirl.api.HtmlFormat.Appendable) = (inarticle,event) => apply(inarticle,event)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:40 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/article/views/viewEvent.scala.html
                  HASH: 89cb5692afe4b782a65861477d5136078e017664
                  MATRIX: 756->1|892->49|920->52|985->97|1015->101|1257->317|1277->329|1330->362|1380->385|1401->397|1446->421|1479->427|1609->530|1630->542|1671->562|1703->567|1751->588|1799->627|1839->629|1885->647|1979->714|2000->726|2047->752|2093->770|2145->791|2176->795
                  LINES: 26->1|29->1|30->2|30->2|32->4|37->9|37->9|37->9|38->10|38->10|38->10|39->11|42->14|42->14|42->14|43->15|44->16|44->16|44->16|45->17|46->18|46->18|46->18|47->19|48->20|49->21
                  -- GENERATED --
              */
          