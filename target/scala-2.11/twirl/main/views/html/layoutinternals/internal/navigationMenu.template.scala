
package views.html.layoutinternals.internal

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
object navigationMenu extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import java.sql.Timestamp

Seq[Any](format.raw/*1.4*/("""

"""),format.raw/*3.1*/("""<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid nav-container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navigation_menu">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" id="home" href=""""),_display_(/*12.45*/application/*12.56*/.routes.Application.index()),format.raw/*12.83*/(""""><img src="/assets/images/Griff, drop shadow.png" id="logo" ></a>
		</div>
		<div class="collapse navbar-collapse" id="navigation_menu">
			<ul class="nav navbar-nav">

				"""),_display_(/*17.6*/if(models.LoginState.getUser().canCreateNewArticle())/*17.59*/ {_display_(Seq[Any](format.raw/*17.61*/("""<li><a href=""""),_display_(/*17.75*/article/*17.82*/.routes.ArticleIn.index()),format.raw/*17.107*/("""">Nytt Innlegg</a></li>""")))}),format.raw/*17.131*/("""
				"""),format.raw/*18.5*/("""<li><a href=""""),_display_(/*18.19*/staticpages/*18.30*/.routes.Bedrift.index()),format.raw/*18.53*/("""">Bedrift</a></li>
				<li><a href=""""),_display_(/*19.19*/calendar/*19.27*/.routes.Calendar.display()),format.raw/*19.53*/("""">Kalender</a></li>
				<!--<li><a href=""""),_display_(/*20.23*/gallery/*20.30*/.routes.Gallery.display()),format.raw/*20.55*/("""">Galleri</a></li>-->
				<li><a href=""""),_display_(/*21.19*/staticpages/*21.30*/.routes.About.index()),format.raw/*21.51*/("""">Om Hybrida</a></li>
				<li><a href=""""),_display_(/*22.19*/staticpages/*22.30*/.routes.Ringen.index()),format.raw/*22.52*/("""">I&IKT-Ringen</a></li>
			</ul>
			<form class="navbar-form navbar-right" role="search" action=""""),_display_(/*24.66*/renders/*24.73*/.routes.Search.search()),format.raw/*24.96*/("""" method="GET">
				<div class="form-group">
					<input id="navbar-search" type="text" class="form-control" name="term" placeholder="Søk"/>
				</div>
			</form>
			<ul class="nav navbar-nav navbar-right">
				"""),_display_(/*30.6*/if(models.LoginState.isValidlyLoggedIn())/*30.47*/ {_display_(Seq[Any](format.raw/*30.49*/("""
					"""),format.raw/*31.6*/("""<li class="dropdown">
						<a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#">"""),_display_(/*32.81*/(models.LoginState.getUser().getName())),format.raw/*32.120*/("""</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href=""""),_display_(/*34.22*/profile/*34.29*/.routes.Profile.index(models.LoginState.getUser().getUsername())),format.raw/*34.93*/("""">Profil</a></li>
							"""),_display_(/*35.9*/if(models.LoginState.getUser.canReadUpdate)/*35.52*/{_display_(Seq[Any](format.raw/*35.53*/("""<li><a href="/update">Update<sup>k</sup></a></li>""")))}),format.raw/*35.103*/(""" """),format.raw/*35.139*/("""
							"""),_display_(/*36.9*/if(models.LoginState.getUser.isFirstUser)/*36.50*/{_display_(Seq[Any](format.raw/*36.51*/("""<li><a href=""""),_display_(/*36.65*/admintools/*36.75*/.routes.Admin.allUsers()),format.raw/*36.99*/("""">Administrer</a></li>""")))}),format.raw/*36.122*/("""
							"""),_display_(/*37.9*/if(models.LoginState.getUser.isInBedkom)/*37.49*/{_display_(Seq[Any](format.raw/*37.50*/("""<li><a href=""""),_display_(/*37.64*/bedpressblock/*37.77*/.routes.BedPresBlock.index()),format.raw/*37.105*/("""">Bedpres Prikking</a></li>
								<li><a href=""""),_display_(/*38.23*/rfid/*38.27*/.routes.RFIDReader.index()),format.raw/*38.53*/("""">RFID Prikking</a></li>
								<li><a href=""""),_display_(/*39.23*/bedkomdatabase/*39.37*/.routes.Bedkomdatabase.index()),format.raw/*39.67*/("""">Bedrifter</a></li>""")))}),format.raw/*39.88*/("""
							"""),_display_(/*40.9*/if(LoginState.getUser.isFirstUser)/*40.43*/{_display_(Seq[Any](format.raw/*40.44*/("""
								"""),format.raw/*41.9*/("""<li><a href=""""),_display_(/*41.23*/admintools/*41.33*/.routes.Admin.logout()),format.raw/*41.55*/("""">Logg ut</a></li>
							""")))}/*42.9*/else/*42.13*/{_display_(Seq[Any](format.raw/*42.14*/("""
								"""),format.raw/*43.9*/("""<li><a href=""""),_display_(/*43.23*/sso/*43.26*/.routes.SSOLogin.logout()),format.raw/*43.51*/("""">Logg ut</a></li>
							""")))}),format.raw/*44.9*/("""
						"""),format.raw/*45.7*/("""</ul>
					</li>
				""")))}),format.raw/*47.6*/("""
				"""),format.raw/*48.5*/("""<li>
					"""),_display_(/*49.7*/if(models.LoginState.isValidlyLoggedIn())/*49.48*/ {_display_(Seq[Any](format.raw/*49.50*/("""

					""")))}/*51.8*/else/*51.13*/{_display_(Seq[Any](format.raw/*51.14*/("""
						"""),format.raw/*52.7*/("""<a href=""""),_display_(/*52.17*/sso/*52.20*/.routes.SSOLogin.login(play.mvc.Http.Context.current().request().path())),format.raw/*52.92*/("""">Logg inn</a>
					""")))}),format.raw/*53.7*/("""
				"""),format.raw/*54.5*/("""</li>
			</ul>
		</div>
	</div>
</nav>
<button href=""""),_display_(/*59.16*/(article.routes.Article.viewArticle("1"))),format.raw/*59.57*/("""" class="feedback btn btn-default btn-lg btn-responsive fixed-bottom-right" onclick="toggleSuggestionBox()">
    <span class="glyphicon glyphicon-bullhorn" aria-hidden="true"></span> Feedback
</button>
"""),_display_(/*62.2*/suggestionBox()),format.raw/*62.17*/("""
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:42 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/views/layoutinternals/internal/navigationMenu.scala.html
                  HASH: 1ceb8a8e781f318c8ae5c886a47a7a4a92250977
                  MATRIX: 750->1|864->3|894->7|1383->469|1403->480|1451->507|1657->687|1719->740|1759->742|1800->756|1816->763|1863->788|1919->812|1952->818|1993->832|2013->843|2057->866|2122->904|2139->912|2186->938|2256->981|2272->988|2318->1013|2386->1054|2406->1065|2448->1086|2516->1127|2536->1138|2579->1160|2706->1260|2722->1267|2766->1290|3010->1508|3060->1549|3100->1551|3134->1558|3264->1661|3325->1700|3425->1773|3441->1780|3526->1844|3579->1871|3631->1914|3670->1915|3752->1965|3782->2001|3818->2011|3868->2052|3907->2053|3948->2067|3967->2077|4012->2101|4067->2124|4103->2134|4152->2174|4191->2175|4232->2189|4254->2202|4304->2230|4382->2281|4395->2285|4442->2311|4517->2359|4540->2373|4591->2403|4643->2424|4679->2434|4722->2468|4761->2469|4798->2479|4839->2493|4858->2503|4901->2525|4947->2553|4960->2557|4999->2558|5036->2568|5077->2582|5089->2585|5135->2610|5193->2638|5228->2646|5282->2670|5315->2676|5353->2688|5403->2729|5443->2731|5471->2742|5484->2747|5523->2748|5558->2756|5595->2766|5607->2769|5700->2841|5752->2863|5785->2869|5871->2928|5933->2969|6165->3175|6201->3190
                  LINES: 26->1|29->1|31->3|40->12|40->12|40->12|45->17|45->17|45->17|45->17|45->17|45->17|45->17|46->18|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|52->24|52->24|52->24|58->30|58->30|58->30|59->31|60->32|60->32|62->34|62->34|62->34|63->35|63->35|63->35|63->35|63->35|64->36|64->36|64->36|64->36|64->36|64->36|64->36|65->37|65->37|65->37|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|67->39|68->40|68->40|68->40|69->41|69->41|69->41|69->41|70->42|70->42|70->42|71->43|71->43|71->43|71->43|72->44|73->45|75->47|76->48|77->49|77->49|77->49|79->51|79->51|79->51|80->52|80->52|80->52|80->52|81->53|82->54|87->59|87->59|90->62|90->62
                  -- GENERATED --
              */
          