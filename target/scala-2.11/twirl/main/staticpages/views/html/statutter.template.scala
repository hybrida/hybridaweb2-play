
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
object statutter extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<link rel="stylesheet" type="text/css" href=""""),_display_(/*1.47*/routes/*1.53*/.Assets.at("stylesheets/bootstrap.min.css")),format.raw/*1.96*/("""">
<link rel="stylesheet" type="text/css" href=""""),_display_(/*2.47*/routes/*2.53*/.Assets.at("stylesheets/staticinfo.css")),format.raw/*2.93*/("""">
<link rel="stylesheet" type="text/css" href=""""),_display_(/*3.47*/routes/*3.53*/.Assets.at("stylesheets/main.css")),format.raw/*3.87*/("""">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href='http://fonts.googleapis.com/css?family=Raleway+Dots' rel='stylesheet' type='text/css'>
<meta charset="UTF-8">
<script type="text/javascript" href="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
<script type="text/javascript" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.13/jquery-ui.min.js"></script>
<script href="/js/jquery.slides.min.js"></script>
<script type="text/javascript">
var _gaq = _gaq || [];
_gaq.push(['_setAccount', 'UA-27346572-1']);
_gaq.push(['_setDomainName', 'hybrida.no']);
_gaq.push(['_trackPageview']);

(function() """),format.raw/*16.13*/("""{"""),format.raw/*16.14*/("""
"""),format.raw/*17.1*/("""var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
"""),format.raw/*20.1*/("""}"""),format.raw/*20.2*/(""")();
</script>
<script href="/js/dev/underscore-min.js"></script>
<script href="/js/require.js"></script>


<div>
    <div class="container">
        <div class="row blank"></div>
        <div class="row">
            <div class="col-md-10 col-md-offset-1 whitebox topright topleft">
                <div class="text-center" id='article-title'>
                    <h1 style="border-bottom: black solid 1px; display: inline-block; width: 350pt;">
                        Statutter
                    </h1>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-10 col-md-offset-1 whitebox line"></div>
        </div>
        <div class="row">
            <div class="col-md-10 col-md-offset-1 whitebox paragraph bottomleft bottomright hiddentopleft hiddentopright">
                <p>
                    <a href="/assets/dokumenter/april2015statutter.pdf">Hybridas Statutter</a>
                </p>

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
                  DATE: Tue Apr 19 17:40:29 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/staticpages/views/statutter.scala.html
                  HASH: 3ebf2a58f17656b46e7525eba5d94ee0f9e5048c
                  MATRIX: 814->0|886->46|900->52|963->95|1039->145|1053->151|1113->191|1189->241|1203->247|1257->281|1959->955|1988->956|2017->958|2336->1250|2364->1251
                  LINES: 29->1|29->1|29->1|29->1|30->2|30->2|30->2|31->3|31->3|31->3|44->16|44->16|45->17|48->20|48->20
                  -- GENERATED --
              */
          