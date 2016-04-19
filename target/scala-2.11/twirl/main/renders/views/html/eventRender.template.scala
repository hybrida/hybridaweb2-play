
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
object eventRender extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[models.Article,models.Event,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(inarticle : models.Article, inevent : models.Event):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.54*/("""
"""),_display_(/*2.2*/(/*This is for rendering a single event preview. It returns the bare html needed for the article to be correctly displayed. CSS should be added as well...*/)),format.raw/*2.159*/("""
"""),format.raw/*3.1*/("""<div style="position: relative;">
	<div style="padding-top: 100%;">
	</div>
	<div class="container-with-set-aspect-ratio">
		<a href=""""),_display_(/*7.13*/(article.routes.Event.viewEvent(String.valueOf(inevent.getId())))),format.raw/*7.78*/("""">
			<div style="position: relative">
				<div style="padding-top: 50%">
				</div>
				<div class="container-with-set-aspect-ratio">
					<img class="super-center" src=""""),_display_(/*12.38*/inarticle/*12.47*/.getImagePath),format.raw/*12.60*/("""" alt="No image available" width="100%" style="top:50%; transform: translateY(-50%);">
				</div>
			</div>
			<h3 class="col-xs-12">
			"""),_display_(/*16.5*/if(inarticle!=null)/*16.24*/{_display_(Seq[Any](format.raw/*16.25*/("""
				"""),_display_(/*17.6*/inarticle/*17.15*/.getTitle),format.raw/*17.24*/("""
			""")))}),format.raw/*18.5*/("""
			"""),format.raw/*19.4*/("""</h3>
		</a>
		"""),_display_(/*21.4*/if(inarticle!=null)/*21.23*/{_display_(Seq[Any](format.raw/*21.24*/("""
			"""),format.raw/*22.4*/("""<p class="col-xs-12">"""),_display_(/*22.26*/inarticle/*22.35*/.getIngress),format.raw/*22.46*/("""</p>
		""")))}),format.raw/*23.4*/("""
		"""),format.raw/*24.3*/("""<div class="container-fluid" style="position: absolute; bottom: 0; background: rgba(245,245,245,1); width: 100%;">
			<div class="row">
				<div class="col-xs-6">"""),_display_(/*26.28*/util/*26.32*/.DateUtil.calendarToColloquial(inevent.getEventHappens)),format.raw/*26.87*/("""</div>
				<div class="col-xs-6">
					<div class="progress" style="margin-bottom: 0;">
						<div class="progress-bar" style="width: """),_display_(/*29.48*/(((inevent.getJoinedUsers.size))*100/inevent.getMaxParticipants)),format.raw/*29.112*/("""%">
						</div>
						<span>
								"""),_display_(/*32.10*/(inevent.getJoinedUsers.size)),format.raw/*32.39*/(""" """),format.raw/*32.40*/("""/ """),_display_(/*32.43*/inevent/*32.50*/.getMaxParticipants),format.raw/*32.69*/("""
						"""),format.raw/*33.7*/("""</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
"""))}
  }

  def render(inarticle:models.Article,inevent:models.Event): play.twirl.api.HtmlFormat.Appendable = apply(inarticle,inevent)

  def f:((models.Article,models.Event) => play.twirl.api.HtmlFormat.Appendable) = (inarticle,inevent) => apply(inarticle,inevent)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/renders/views/eventRender.scala.html
                  HASH: 3a3a861b1f151ff31cd1758c148300379b8c98f2
                  MATRIX: 758->1|898->53|926->56|1104->213|1132->215|1297->354|1382->419|1586->596|1604->605|1638->618|1806->760|1834->779|1873->780|1906->787|1924->796|1954->805|1990->811|2022->816|2066->834|2094->853|2133->854|2165->859|2214->881|2232->890|2264->901|2303->910|2334->914|2526->1079|2539->1083|2615->1138|2780->1276|2866->1340|2935->1382|2985->1411|3014->1412|3044->1415|3060->1422|3100->1441|3135->1449
                  LINES: 26->1|29->1|30->2|30->2|31->3|35->7|35->7|40->12|40->12|40->12|44->16|44->16|44->16|45->17|45->17|45->17|46->18|47->19|49->21|49->21|49->21|50->22|50->22|50->22|50->22|51->23|52->24|54->26|54->26|54->26|57->29|57->29|60->32|60->32|60->32|60->32|60->32|60->32|61->33
                  -- GENERATED --
              */
          