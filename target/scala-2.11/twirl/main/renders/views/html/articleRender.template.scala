
package renders.views.html

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
object articleRender extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[models.Article,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(inarticle : models.Article):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.30*/("""
"""),_display_(/*2.2*/(/*This is for rendering a single article preview. It returns the bare html needed for the article to be correctly displayed. CSS should be added as well...*/)),format.raw/*2.161*/("""
"""),format.raw/*3.1*/("""<!--<img src=""""),_display_(/*3.16*/(inarticle.getImagePath())),format.raw/*3.42*/("""" alt="image">-->
<div style="position: relative;">
	<div style="padding-top: 100%;"></div>
	<div class="container-with-set-aspect-ratio">
		<a href=""""),_display_(/*7.13*/article/*7.20*/.routes.Article.viewArticle(String.valueOf(inarticle.getId()))),format.raw/*7.82*/("""">
			<div style="position: relative">
				<div style="padding-top: 50%"></div>
				<div class="container-with-set-aspect-ratio">
					<img class="super-center" src=""""),_display_(/*11.38*/inarticle/*11.47*/.getImagePath),format.raw/*11.60*/("""" alt="No image available" width="100%">
				</div>
			</div>
			<h3 class="col-xs-12">
			"""),_display_(/*15.5*/inarticle/*15.14*/.getTitle),format.raw/*15.23*/("""
			"""),format.raw/*16.4*/("""</h3>
		</a>
		<p class="col-xs-12">"""),_display_(/*18.25*/inarticle/*18.34*/.getIngress),format.raw/*18.45*/("""</p>
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
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/renders/views/articleRender.scala.html
                  HASH: f6b21e7aae0ed8242fd3ec5b517a25f0cc68a909
                  MATRIX: 747->1|863->29|891->32|1071->191|1099->193|1140->208|1186->234|1367->389|1382->396|1464->458|1662->629|1680->638|1714->651|1836->747|1854->756|1884->765|1916->770|1982->809|2000->818|2032->829
                  LINES: 26->1|29->1|30->2|30->2|31->3|31->3|31->3|35->7|35->7|35->7|39->11|39->11|39->11|43->15|43->15|43->15|44->16|46->18|46->18|46->18
                  -- GENERATED --
              */
          