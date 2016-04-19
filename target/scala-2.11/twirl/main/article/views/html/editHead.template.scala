
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

/**/
object editHead extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.4*/("""
"""),format.raw/*2.1*/("""<script src="/assets/ckeditor/ckeditor.js"></script>
<style>

/* Style the CKEditor element to look like a textfield */
.cke_textarea_inline """),format.raw/*6.22*/("""{"""),format.raw/*6.23*/("""
"""),format.raw/*7.1*/("""padding : 10px ;
height : 200px ;
overflow : auto ;
background-color : #ffffff ;
border : 1px solid gray ;
-webkit-appearance : textfield ;
"""),format.raw/*13.1*/("""}"""),format.raw/*13.2*/("""

"""),format.raw/*15.1*/("""</style>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:40 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/article/views/editHead.scala.html
                  HASH: 253eca48f4e96817f7424fd0e94968d0573e95e1
                  MATRIX: 727->1|816->3|844->5|1016->150|1044->151|1072->153|1245->299|1273->300|1304->304
                  LINES: 26->1|29->1|30->2|34->6|34->6|35->7|41->13|41->13|43->15
                  -- GENERATED --
              */
          