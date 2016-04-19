
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
object searchBody extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,List[Html],Int,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String, rendersx: List[Html], page: Int = 0, term: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.68*/("""
"""),format.raw/*2.1*/("""<div class="container-fluid center-container">
	<div class="row space-below space-above">
		<div class="col-xs-12 space-above">
			<div class="page-box">
				<h5 class="top-text">"""),_display_(/*6.27*/title),format.raw/*6.32*/("""</h5>
					"""),_display_(/*7.7*/for(renderable <- rendersx) yield /*7.34*/{_display_(Seq[Any](format.raw/*7.35*/("""
						"""),_display_(/*8.8*/renderable),format.raw/*8.18*/("""
					""")))}),format.raw/*9.7*/("""
				"""),format.raw/*10.5*/("""<div class="clearfix"></div>
				<form action=""""),_display_(/*11.20*/renders/*11.27*/.routes.Search.search()),format.raw/*11.50*/("""" method="get">
					<input type="hidden" name="term" value=""""),_display_(/*12.47*/term),format.raw/*12.51*/("""">
					<input type="hidden" name="page" value=""""),_display_(/*13.47*/(page+1)),format.raw/*13.55*/("""">
					<input class="btn btn-primary" value="Neste Side" type="submit">
				</form>
			</div>
		</div>
"""),format.raw/*21.3*/("""
	"""),format.raw/*22.2*/("""</div>
</div>
"""))}
  }

  def render(title:String,rendersx:List[Html],page:Int,term:String): play.twirl.api.HtmlFormat.Appendable = apply(title,rendersx,page,term)

  def f:((String,List[Html],Int,String) => play.twirl.api.HtmlFormat.Appendable) = (title,rendersx,page,term) => apply(title,rendersx,page,term)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/renders/views/searchBody.scala.html
                  HASH: 98526d720fedd4692acc3a60ed8e03db80b764bc
                  MATRIX: 758->1|912->67|940->69|1150->253|1175->258|1213->271|1255->298|1293->299|1327->308|1357->318|1394->326|1427->332|1503->381|1519->388|1563->411|1653->474|1678->478|1755->528|1784->536|1920->747|1950->750
                  LINES: 26->1|29->1|30->2|34->6|34->6|35->7|35->7|35->7|36->8|36->8|37->9|38->10|39->11|39->11|39->11|40->12|40->12|41->13|41->13|46->21|47->22
                  -- GENERATED --
              */
          