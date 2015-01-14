function Project(name, filePath, projectType) {
  this.name = name;
  this.filePath = filePath;
  this.projectType = projectType ? projectType : ProjectType.JS;
}

var ProjectType = {
  JS: "javascript",
  LESS: "less"
}

Project.prototype.htmlRepresentation = function() {
  return "<div  class=\"project wow flipInX invisible red\"><span class=\"name\">" + this.name + "</span><p class=\"file-path\"> " + this.filePath + " </p></div>"
};


var ProjectManager = {
  currentProjects: {},
  add: function(project) {
    if ($.inArray(project.name, Object.getOwnPropertyNames(this.currentProjects)) == -1) {
      this.currentProjects[project.name] = project;
    } else {
      throw "Project already exists!";
    }
  },
  displayProjects: function() {
    $(".projects").html("");
    for (var project in this.currentProjects) {
      $(".projects").append(this.currentProjects[project].htmlRepresentation());
    }
  }
}