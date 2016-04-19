
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
object tillitsvalgte extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

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

    (function() """),format.raw/*16.17*/("""{"""),format.raw/*16.18*/("""
        """),format.raw/*17.9*/("""var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
    """),format.raw/*20.5*/("""}"""),format.raw/*20.6*/(""")();
</script>
<script href="/js/dev/underscore-min.js"></script>
<script href="/js/require.js"></script>



    <div class="container">
        <div class="row blank"></div>
        <div class="row">
            <div class="col-md-10 col-md-offset-1 whitebox topright topleft">
                <div class="text-center" id='article-title'>
                    <h1 style="border-bottom: black solid 1px; display: inline-block; width: 350pt;">
                        Tillitsvalgte
                    </h1>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-10 col-md-offset-1 whitebox line"></div>
        </div>
        <div class="row">
            <div class="col-md-10 col-md-offset-1 whitebox paragraph bottomleft bottomright hiddentopleft hiddentopright">
                <h2 style="...">
                    Tillitsvalgte
                </h2>
                <h3> Programmstillitsvalgte (PTVer)</h3>
                <p> PTVene skal ivareta studentenes interesser, og representerer dem ved studieprogrammet. De er også bindeleddet mellom studentene og studieprogrammets ledelse. PTVene er:</p>
                <p>  - Hans Edvard Hafskolt (3. klasse): <a href="mailto:hansehaf@stud.ntnu.no">hansehaf@stud.ntnu.no</a></p>
                <p>  - Henrik Løfaldli (3. klasse): <a href="mailto:henrilof@stud.ntnu.no">henrilof@stud.ntnu.no</a>"</p>
                <p> &nbsp; </p>
                <h3> Klassetillitsvalgte (KTVer)</h3>
                <p> KTVene er i hovedsak kontaktpersoner for studentene i sin klasse. Som KTV skal man være tilgengelig for den enkelte student og hjelpe han/henne med problemer som angår studiet og klassesituasjonen, evt. henvise videre til instanser som kan gi hjelp. KTVene er:</p>
                <h4> 1. Klasse</h4>
                <p> - Heidi Tomtum: <a href="mailto:heidto@stud.ntnu.no"> heidto@stud.ntnu.no</a></p>
                <p> - Sven Martin Kørner: <a href="mailto:svenmk@stud.ntnu.no">svenmk@stud.ntnu.no</a></p>
                <p> &nbsp;</p>
                <h4> 2. Klasse </h4>
                <p> - Jan Birger Larsen: <a href="mailto:janblar@stud.ntnu.no"> janblar@stud.ntnu.no</a></p>
                <p> - Andreas Børhaug: <a href="mailto:andrborh@stud.ntnu.no">andrborh@stud.ntnu.no</a></p>
                <p> &nbsp;</p>
                <h4> 3.Klasse </h4>
                <p> - Henrik Løfaldli: <a href="mailto:aasesm@stud.ntnu.no">henrilof@stud.ntnu.no</a></p>
                <p> - Øystein Hauan: <a href="mailto:oysteibh@stud.ntnu.no">oysteibh@stud.ntnu.no</a></p>
                <p> &nbsp;</p>
                <h4> 4.Klasse </h4>
                <p> - William Knudtzon: <a href="mailto:williawk@stud.ntnu.no">williawk@stud.ntnu.no</a></p>
                <p> - Aase Melaaen: <a href="mailto:aasesm@stud.ntnu.no">aasesm@stud.ntnu.no</a></p>
                <p> &nbsp;</p>
                <h4> 5.Klasse </h4>
                <p> - Simen Lillehagen: <a href="mailto:simenlil@stud.ntnu.no">simenlil@stud.ntnu.no</a></p>
                <p> - Karoline L. Rykkelid: <a href="mailto:karolinr@stud.ntnu.no">karolinr@stud.ntnu.no</a></p>

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
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/staticpages/views/tillitsvalgte.scala.html
                  HASH: c51e634e0938804bf19f06aade25ff91e87fa474
                  MATRIX: 818->0|890->46|904->52|967->95|1043->145|1057->151|1117->191|1193->241|1207->247|1261->281|1983->975|2012->976|2049->986|2388->1298|2416->1299
                  LINES: 29->1|29->1|29->1|29->1|30->2|30->2|30->2|31->3|31->3|31->3|44->16|44->16|45->17|48->20|48->20
                  -- GENERATED --
              */
          