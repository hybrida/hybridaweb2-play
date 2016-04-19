
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
object arrkom extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<div>
    <div class="container">
        <div class="row space-above space-below">
            <div class="col-md-10 col-md-offset-1 transparent-box rounded">
                <div class="text-center">
                    <h1>Arrangementkomitéen</h1>
                </div>
                <div class="paragraph">
                    <h2>Arrkom</h2>
                    <p>
                        Her kommer en flott side om arrkom
                    </p>
                    <p>
                        <img class="center-block" src="/assets/images/arrkom_bilde.jpg">
                    </p>
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
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/staticpages/views/arrkom.scala.html
                  HASH: 63f20a22c49da6ca0347403b56e42ee3c9a33719
                  MATRIX: 811->0
                  LINES: 29->1
                  -- GENERATED --
              */
          