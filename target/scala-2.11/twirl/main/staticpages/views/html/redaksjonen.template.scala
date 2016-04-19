
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
object redaksjonen extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.4*/("""
"""),format.raw/*2.1*/("""<div class="article-bg" style="background-image: url("""),_display_(/*2.55*/routes/*2.61*/.Assets.at("images/nys.png")),format.raw/*2.89*/("""">
    <div class="container-fluid center-container">
        <div class="row space-below">
            <div class="col-md-8 col-md-offset-2 space-above">
                <div class="transparent-box rounded">
                    <h1>Redaksjonen</h1>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer luctus purus lectus, non iaculis massa iaculis eu. Pellentesque turpis enim, vestibulum non nibh vitae, vestibulum pretium ante. Aliquam laoreet fermentum consequat. Aliquam lectus nibh, mollis quis pellentesque at, semper ut sem. Fusce in eros maximus, ultrices urna ut, sodales justo. Praesent sagittis elementum neque vel sagittis. Nullam orci lorem, pulvinar mollis molestie quis, maximus vitae ante. Aliquam ultrices, turpis quis auctor hendrerit, justo nulla pharetra purus, ac consequat leo odio sed orci. Donec felis velit, pulvinar nec porta non, placerat vitae augue. Etiam id nisi ullamcorper, laoreet justo ut, vestibulum nisi. Sed vel fermentum turpis. Integer auctor ut quam scelerisque ullamcorper. Nam tincidunt tempor erat malesuada accumsan.
                    </p>
                    <p>
                        Pellentesque euismod iaculis eros eu consectetur. Cras dignissim malesuada suscipit. Sed eget imperdiet felis, vel pulvinar urna. In pretium nunc a quam mollis efficitur. Duis iaculis tincidunt mauris, eget suscipit ipsum venenatis in. Nunc et elit id mi ultrices mollis. Ut vulputate nisi in enim gravida rutrum. Praesent euismod nunc eget est luctus, sit amet luctus sem sodales. Aliquam suscipit porta erat at tempor. Mauris ante urna, feugiat in consectetur vitae, ullamcorper et sapien.
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:42 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/staticpages/views/redaksjonen.scala.html
                  HASH: 7a24227196a034bed3e6b25d6de3ed9021ad12f4
                  MATRIX: 734->1|823->3|851->5|931->59|945->65|993->93
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2
                  -- GENERATED --
              */
          