
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
import models.Article
import models.Event
/**/
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*3.4*/("""
"""),format.raw/*4.1*/("""<div>
	<div class="container-fluid center-container">
		<script src="/assets/ckeditor/ckeditor.js"></script>
		<style>

		/* Style the CKEditor element to look like a textfield */
		.cke_textarea_inline """),format.raw/*10.24*/("""{"""),format.raw/*10.25*/("""
		"""),format.raw/*11.3*/("""padding : 10px ;
		height : 200px ;
		overflow : auto ;
		background-color : #ffffff ;
		border : 1px solid gray ;
		-webkit-appearance : textfield ;
		"""),format.raw/*17.3*/("""}"""),format.raw/*17.4*/("""
		"""),format.raw/*18.3*/("""</style>
		<div class="row space-below">
			<div class="col-md-8 space-above">
				<div class="transparent-box">
					<h3><p class="text-center">
						Ny artikkel/event
					</p></h3>
					<form name="Article" action=""""),_display_(/*25.36*/article/*25.43*/.routes.ArticleIn.save()),format.raw/*25.67*/("""" method="POST" enctype="multipart/form-data">
						"""),_display_(/*26.8*/dependencies/*26.20*/.articleInputs(new Article())),format.raw/*26.49*/("""
						"""),format.raw/*27.7*/("""<div class="form-group" data-toggle="buttons">
							<label class="checkbox btn btn-primary form-control" onclick="$ ('.showhide').toggle ();">
								<input class="checkbox-center" id="arr" type="checkbox" name="event" value="Event">
								Arrangement?
							</label>
						</div>
						<div class="showhide" id="showhide" name="showhide" style="display: none;">
							<br>
							"""),_display_(/*35.9*/dependencies/*35.21*/.eventInputs(new Event())),format.raw/*35.46*/("""
						"""),format.raw/*36.7*/("""</div>

						<div class="form-group">
							<input class="btn btn-primary form-control" type="submit" value="Post">
						</div>

					</form>
				</div>
			</div>
			<div class="col-md-4 space-above">
				<div class="transparent-box">
					<h5><p>Her skal det stå en del innformasjon om denne formen:</p></h5>
					<hr>
					<p>
						Det skal stå litt om hva de forskjellige feltene betyr, samt litt om hvordan vi liker å ha det her på hybridasiden!
						<br>
						Før du oppretter ett nytt event eller en artikkel, ser vi gjerne at du leser igjennom disse retningslinjene
						slik at vi får en kul side, med kule bilder, og kul formatering, som ser sinnsykt kul ut hele tiden, alltid!
						<br>
					</p>
					<strong><p>
						Grensen står for klassetrinnet som har lov til å melde seg opp. Tallet står for avslutningsår.
					</p></strong>
					<br>
				</div>
			</div>
		</div>
	</div>
</div>
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:40 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/article/views/index.scala.html
                  HASH: 68b70e52f7fe339beb4d14f834d2ef27e4b6a1a7
                  MATRIX: 765->47|854->49|882->51|1119->260|1148->261|1179->265|1364->423|1392->424|1423->428|1677->655|1693->662|1738->686|1819->741|1840->753|1890->782|1925->790|2348->1187|2369->1199|2415->1224|2450->1232
                  LINES: 27->3|30->3|31->4|37->10|37->10|38->11|44->17|44->17|45->18|52->25|52->25|52->25|53->26|53->26|53->26|54->27|62->35|62->35|62->35|63->36
                  -- GENERATED --
              */
          