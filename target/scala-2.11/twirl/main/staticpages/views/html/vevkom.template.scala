
package staticpages.views.html

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
object vevkom extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<div class="article-bg" style="background-image: url(../assets/images/muse.jpg)">
	<div class="container">
		<div class="row space-above space-below">

			<div class="col-md-6 col-md-offset-5 transparent-box rounded">
				<div class="text-center">
					<h1>VevKom</h1>
				</div>
				<div class="paragraph">
					<p>
						<strong>Vevkom er en av komitéene til linjeforeningen Hybrida, og er ansvarlig for utvikling, vedlikehold og kontroll av nettsiden til Hybrida. </strong></p>
                    <p>
						 Vevkom er linjeforeningens teknosentriske komité. Dette er komitéen for hybrider som er glad i teknologi og programmering, og ønsker å kombinere denne interessen med sin kjærlighet til linjeforeningen. Vi har som hovedoppgave å sørge for at Hybrida har en pen og velfungerende hjemmeside. I tillegg arrangerer vi HybridLAN hvert semester, der vi tilbyr konkurranser, pizza, en chill-lounge (aka Oda-rommet) for de som får 1337-overdose, og selvfølgelig gaming til langt ut i morgentimene. Komiteén har i mer enn ett år nå holdt på med utviklingen av Hybridas nye nettside, med nytt og bedre design, samt bedre… vel, alt, egentlig! Lanseringen skal skje til <s>høsten</s> våren, og for å nå det målet holder vi ukentlige arbeidsmøter hvor agendaen består av kakespising, diskusjon, programmering og mer kakespising.  </p>
					<br>
					<p>
                        Har du noe på hjertet, ikke nøl med å ta kontakt!
					<p>
						<strong>Vevkomitésjef</strong> Simen Norderud Jensen simennje@stud.ntnu.no</p>
				</div>
				<div>
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
                  DATE: Tue Apr 19 17:27:42 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/staticpages/views/vevkom.scala.html
                  HASH: 96ea27e887f0c80240a69594d3e4cf30825248b0
                  MATRIX: 811->0
                  LINES: 29->1
                  -- GENERATED --
              */
          