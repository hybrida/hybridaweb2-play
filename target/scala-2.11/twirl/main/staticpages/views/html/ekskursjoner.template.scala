
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
object ekskursjoner extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<div class="article-bg">
    <div class="container">
        <div class="row space-above"></div>
            <div class="row">
                <div class="col-md-10 col-md-offset-1 transparent-box rounded">
                    <div class="text-center" id='article-title'>
                        <h1 style="border-bottom: black solid 1px; display: inline-block; width: 350pt;">
                            Ekskursjoner
                        </h1>
                    </div>
                </div>
            </div>

        <div class="row space-above space-below">
            <div class="col-md-10 col-md-offset-1 transparent-box paragraph rounded">
                <div>

                    <!--
                    <h2 style="border-bottom: black dotted 1px; display: inline-block">
                        Om
                    </h2>
                    -->
                    <p>
                        Som medlem i I&IKT-ringen kan man få muligheten til å arrangere ekskursjoner. Bedriften vil da
                        få besøk av en gruppe studenter, der de vil få muligheten til å gi en omvisning og fortelle om
                        bedriften i sitt eget miljø.
                    </p>
                    <p>
                        Annethvert år reiser studenter fra 3.- og 4.-klasse på ekskursjon til utlandet. For bedrifter
                        som også her virksomhet har vil det kunne ordnes besøk i disse lokalene. Dette er en fin mulighet
                        til å vise hvordan bedriften virker i andre deler av verden.
                    </p>


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
                  DATE: Tue Apr 19 17:37:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/staticpages/views/ekskursjoner.scala.html
                  HASH: feb60c9099736f09d1bc84ad6be104508b4c6a70
                  MATRIX: 817->0
                  LINES: 29->1
                  -- GENERATED --
              */
          