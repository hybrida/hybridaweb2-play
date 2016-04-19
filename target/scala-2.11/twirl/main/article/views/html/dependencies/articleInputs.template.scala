
package article.views.html.dependencies

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
/**/
object articleInputs extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Article,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(inarticle: Article):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*2.22*/("""

"""),format.raw/*4.1*/("""<div class="form-group">
<textarea class="form-control" type="text" name="title">"""),_display_(/*5.58*/inarticle/*5.67*/.getTitle),format.raw/*5.76*/("""</textarea>
<textarea class="form-control" name="ingress" onfocus="">"""),_display_(/*6.59*/inarticle/*6.68*/.getIngress),format.raw/*6.79*/("""</textarea>
<textarea id="editor1" class="form-control" rows="12" cols="75" name="text">"""),_display_(/*7.78*/inarticle/*7.87*/.getText),format.raw/*7.95*/("""</textarea>
<input class="pad_1percent_top center_block form-control" style="display : block ; background-color : #c3c3c3 ; " type="file" name="picture">
<script>
        CKEDITOR.disableAutoInline = true;
        CKEDITOR.inline('editor1');
</script>
</div>"""))}
  }

  def render(inarticle:Article): play.twirl.api.HtmlFormat.Appendable = apply(inarticle)

  def f:((Article) => play.twirl.api.HtmlFormat.Appendable) = (inarticle) => apply(inarticle)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:40 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/article/views/dependencies/articleInputs.scala.html
                  HASH: 505fe17e89283fe8d3c1a79c2a6bdf150c921803
                  MATRIX: 774->25|882->45|912->49|1021->132|1038->141|1067->150|1164->221|1181->230|1212->241|1328->331|1345->340|1373->348
                  LINES: 26->2|29->2|31->4|32->5|32->5|32->5|33->6|33->6|33->6|34->7|34->7|34->7
                  -- GENERATED --
              */
          