package com.devon.treditor.payload;

import java.util.Objects;
import com.devon.treditor.entity.whiteboard.shapes.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Информация о проекте
 */
@ApiModel(description = "Информация о проекте")
@Validated


public class ProjectInfo   {
  @JsonProperty("shapes")
  @Valid
  private List<Shape> shapes = null;

  public ProjectInfo shapes(List<Shape> shapes) {
    this.shapes = shapes;
    return this;
  }

  public ProjectInfo addShapesItem(Shape shapesItem) {
    if (this.shapes == null) {
      this.shapes = new ArrayList<>();
    }
    this.shapes.add(shapesItem);
    return this;
  }

  /**
   * коллекция всех фигур в проекте
   * @return shapes
  **/
  @ApiModelProperty(value = "коллекция всех фигур в проекте")
      @Valid
    public List<Shape> getShapes() {
    return shapes;
  }

  public void setShapes(List<Shape> shapes) {
    this.shapes = shapes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProjectInfo projectInfo = (ProjectInfo) o;
    return Objects.equals(this.shapes, projectInfo.shapes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shapes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjectInfo {\n");
    
    sb.append("    shapes: ").append(toIndentedString(shapes)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
