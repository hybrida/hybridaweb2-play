
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
object rendersBody extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,List[Html],Int,String,play.twirl.api.HtmlFormat.Appendable] {

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
			</div>
		</div>
"""),format.raw/*16.3*/("""
	"""),format.raw/*17.2*/("""</div>
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
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/renders/views/rendersBody.scala.html
                  HASH: 7470dd8c9a086db97d74159a6919bbd9356f607c
                  MATRIX: 759->1|913->67|941->69|1151->253|1176->258|1214->271|1256->298|1294->299|1328->308|1358->318|1395->326|1428->332|1506->485|1536->488
                  LINES: 26->1|29->1|30->2|34->6|34->6|35->7|35->7|35->7|36->8|36->8|37->9|38->10|41->16|42->17
                  -- GENERATED --
              */
          