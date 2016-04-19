
package admintools.views.html

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
object bulkUserForm extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,String,List[String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(output: String, input: String, serializedData:List[String]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.62*/("""
"""),format.raw/*2.1*/("""<div style="text-align: left;">
    <h3>Legg til brukere</h3>
    """),_display_(/*4.6*/if(output)/*4.16*/{_display_(Seq[Any](format.raw/*4.17*/("""<pre class="output" style="height:200px;padding-top:0px;padding-bottom:0px;">"""),_display_(/*4.95*/output),format.raw/*4.101*/("""</pre>""")))}),format.raw/*4.108*/("""
    """),format.raw/*5.5*/("""<div class="progress hidden">
        <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="transition:none;"></div>
    </div>
    <div class="hidden users">
        """),_display_(/*9.10*/for(user <- serializedData) yield /*9.37*/ {_display_(Seq[Any](format.raw/*9.39*/("""
            """),format.raw/*10.13*/("""<div class="user">"""),_display_(/*10.32*/user),format.raw/*10.36*/("""</div>
        """)))}),format.raw/*11.10*/("""
    """),format.raw/*12.5*/("""</div>
    <div class="well" style="min-width: 630px;">
        <h5>Format:</h5>
        <div style="font-family: monospace; font-size:10px">
            <strong>"""),_display_(/*16.22*/("olamnor,Ola,Nordmann,Mellomnavn,ola@nordmann.no,12345678,1900,Marin teknikk,true,false,M,1814-05-17,")),format.raw/*16.126*/("""</strong><br>
                """),_display_(/*17.18*/Html("brukernavn  etternavn           e-postadresse            avgangsår          medlem     kjønn(M/F/U)".replaceAll(" ", "&nbsp;"))),format.raw/*17.151*/("""<br>
                """),_display_(/*18.18*/Html("        fornavn      mellomnavn                 telefonnr.    spesialisering     bedkom  fødselsdato".replaceAll(" ", "&nbsp;"))),format.raw/*18.152*/("""<br>
        </div>
    </div>
    <form action=""""),_display_(/*21.20*/admintools/*21.30*/.routes.Admin.bulkUsers()),format.raw/*21.55*/("""" method="post" enctype="multipart/form-data" style="display:block;">
        <div class="form-group"><input class="form-control" type="file" name="userdataFile"></div>
        <div class="form-group"><textarea class="form-control" name="userdata" style="display:block; width: 100%">"""),_display_(/*23.116*/input),format.raw/*23.121*/("""</textarea></div>
        <div class="form-group"><input class="btn btn-primary form-control" type="submit" style="display:block; width: 100%"></div>
    </form>
</div>
<script>
    function nextUser(elem, i, issues) """),format.raw/*28.40*/("""{"""),format.raw/*28.41*/("""
        """),format.raw/*29.9*/("""$.ajax("""),format.raw/*29.16*/("""{"""),format.raw/*29.17*/("""
            """),format.raw/*30.13*/("""url: """"),_display_(/*30.20*/admintools/*30.30*/.routes.Admin.bulkAddSingle.url),format.raw/*30.61*/("""?data=" + elem.html()
            , success: function(data) """),format.raw/*31.39*/("""{"""),format.raw/*31.40*/("""
                """),format.raw/*32.17*/("""var output = $(".output");
                output.append($("<span>").text(data));
                elem.remove();
                var progressBar = $(".progress-bar");
                progressBar.attr("aria-valuenow", i).css("width",(5 + 95*i/progressBar.attr("aria-valuemax"))+"%");
                var elems = $(".user");
                if(data.indexOf("  ") > -1) issues.push(data);
                if(elems.length > 0) nextUser(elems.first(), ++i, issues);
                else """),format.raw/*40.22*/("""{"""),format.raw/*40.23*/("""
                    """),format.raw/*41.21*/("""output.append("----------------------------------------------------------------\n");
                    output.append("Finished with " + issues.length + " issue" + (issues.length!=1?"s":"") +".\n");
                    progressBar.removeClass("progress-bar-striped active");
                    if(issues.length > 0) progressBar.addClass("progress-bar-warning");
                    else progressBar.addClass("progress-bar-success");
                    for(var issue in issues) output.append($("<span>").text(issues[issue]).addClass("error"));
                """),format.raw/*47.17*/("""}"""),format.raw/*47.18*/("""
            """),format.raw/*48.13*/("""}"""),format.raw/*48.14*/(""", error: function(jqXHR, textStatus, errorThrown) """),format.raw/*48.64*/("""{"""),format.raw/*48.65*/("""
                """),format.raw/*49.17*/("""var output = $(".output");
                output.append($("<span>").text(textStatus + ": " + errorThrown));
                elem.addClass("error");
                var progressBar = $(".progress-bar");
                progressBar.attr("aria-valuenow", i).css("width",(95*i/progressBar.attr("aria-valuemax"))+"%");
                progressBar.removeClass("progress-bar-striped active");
                progressBar.addClass("progress-bar-danger");
            """),format.raw/*56.13*/("""}"""),format.raw/*56.14*/("""
        """),format.raw/*57.9*/("""}"""),format.raw/*57.10*/(""");
    """),format.raw/*58.5*/("""}"""),format.raw/*58.6*/("""
    """),format.raw/*59.5*/("""$(document).ready(function()"""),format.raw/*59.33*/("""{"""),format.raw/*59.34*/("""
        """),format.raw/*60.9*/("""var elems = $(".user");
        if(elems.length > 0) """),format.raw/*61.30*/("""{"""),format.raw/*61.31*/("""
            """),format.raw/*62.13*/("""$(".progress").removeClass("hidden");
            $(".progress-bar").attr("aria-valuemax", elems.length);
            nextUser(elems.first(), 1, []);
        """),format.raw/*65.9*/("""}"""),format.raw/*65.10*/("""
    """),format.raw/*66.5*/("""}"""),format.raw/*66.6*/(""");
</script>"""))}
  }

  def render(output:String,input:String,serializedData:List[String]): play.twirl.api.HtmlFormat.Appendable = apply(output,input,serializedData)

  def f:((String,String,List[String]) => play.twirl.api.HtmlFormat.Appendable) = (output,input,serializedData) => apply(output,input,serializedData)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:40 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/admintools/views/bulkUserForm.scala.html
                  HASH: 4202d146b1570d466b7bb981392cb13e382e9514
                  MATRIX: 761->1|909->61|937->63|1031->132|1049->142|1087->143|1191->221|1218->227|1256->234|1288->240|1568->494|1610->521|1649->523|1691->537|1737->556|1762->560|1810->577|1843->583|2037->750|2163->854|2222->886|2377->1019|2427->1042|2583->1176|2663->1229|2682->1239|2728->1264|3042->1550|3069->1555|3319->1777|3348->1778|3385->1788|3420->1795|3449->1796|3491->1810|3525->1817|3544->1827|3596->1858|3685->1919|3714->1920|3760->1938|4278->2428|4307->2429|4357->2451|4953->3019|4982->3020|5024->3034|5053->3035|5131->3085|5160->3086|5206->3104|5701->3571|5730->3572|5767->3582|5796->3583|5831->3591|5859->3592|5892->3598|5948->3626|5977->3627|6014->3637|6096->3691|6125->3692|6167->3706|6355->3867|6384->3868|6417->3874|6445->3875
                  LINES: 26->1|29->1|30->2|32->4|32->4|32->4|32->4|32->4|32->4|33->5|37->9|37->9|37->9|38->10|38->10|38->10|39->11|40->12|44->16|44->16|45->17|45->17|46->18|46->18|49->21|49->21|49->21|51->23|51->23|56->28|56->28|57->29|57->29|57->29|58->30|58->30|58->30|58->30|59->31|59->31|60->32|68->40|68->40|69->41|75->47|75->47|76->48|76->48|76->48|76->48|77->49|84->56|84->56|85->57|85->57|86->58|86->58|87->59|87->59|87->59|88->60|89->61|89->61|90->62|93->65|93->65|94->66|94->66
                  -- GENERATED --
              */
          