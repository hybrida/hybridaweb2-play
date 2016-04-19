
package griffensorden.views.html

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
object nominationBody extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<div class="helesiden">
    <div class="container">
        <div class="row blank"></div>
        <div class="row">
            <div class="col-md-6 col-md-offset-5 whitebox topright topleft GO">
                <img src="/assets/images/GO.png" align="middle">
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 col-md-offset-5 whitebox line">
                ________________________________________________________
            </div>
        </div>

        <div class="row">
            <form name="Article" action=""""),_display_(/*16.43*/article/*16.50*/.routes.ArticleIn.save()),format.raw/*16.74*/("""" method="POST" enctype="multipart/form-data">

                <div class="col-md-6 col-md-offset-5 whitebox paragraph bottomleft bottomright hiddentopleft hiddentopright">
                    <p>
                        Navn på hybrid
                    </p>
                    <p>
                        <textarea class="form-control" placeholder="Navn" type="text" name="name"></textarea>
                    </p>
                    <p>
                        Begrunnelse for nominasjon
                    </p>
                    <p>
                        <textarea class="form-control" placeholder="Begrunnelse" type="text" id="nominasjonin" name="reason"></textarea>
                    </p>
                    <p>
                        <input type="submit" value="Submit">
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
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/griffensorden/views/nominationBody.scala.html
                  HASH: e3ad31443ca7915e49ac42abba374782b17a1812
                  MATRIX: 821->0|1425->577|1441->584|1486->608
                  LINES: 29->1|44->16|44->16|44->16
                  -- GENERATED --
              */
          