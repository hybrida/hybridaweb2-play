
package gallery.views.html

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
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[GalleryImage],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(images: List[GalleryImage]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.30*/("""

"""),format.raw/*3.1*/("""<form name="GalleryImage" style="text-align: left; margin-bottom: 20px" action=""""),_display_(/*3.82*/gallery/*3.89*/.routes.Gallery.uploadGalleryImage()),format.raw/*3.125*/("""" method="POST" enctype="multipart/form-data">
    <div class="form-group">
        <lable for="image">Bildet (eller fil)</lable>
        <input type="file" id="image" name="image"></input>
        <p class="help-block">Last opp en fil til profilen din. Er det et bilde, blir den lagt til galleriet.</p>
    </div>
    <div class="form-group">
        <lable for="title">Tittel på bildet</lable>
        <input type="text" id="title" class="form-control" placeholder="Tittel" name="title"></input>
    </div>
    <div class="form-group">
        <lable for="desc">Beskrivelse av bildet</lable>
        <textarea rows="3" id="desc" class="form-control" name="description"></textarea>
    </div>
    <button type="submit" class="btn btn-default">Send</button>
</form>

"""),_display_(/*20.2*/galleryContainer(images)),format.raw/*20.26*/("""
"""),_display_(/*21.2*/galleryFrameworkAlt(true)))}
  }

  def render(images:List[GalleryImage]): play.twirl.api.HtmlFormat.Appendable = apply(images)

  def f:((List[GalleryImage]) => play.twirl.api.HtmlFormat.Appendable) = (images) => apply(images)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/gallery/views/index.scala.html
                  HASH: c4c1a0143a7c5af1063cde36dfd2121451984b47
                  MATRIX: 743->1|859->29|889->33|996->114|1011->121|1068->157|1879->942|1924->966|1953->969
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|48->20|48->20|49->21
                  -- GENERATED --
              */
          