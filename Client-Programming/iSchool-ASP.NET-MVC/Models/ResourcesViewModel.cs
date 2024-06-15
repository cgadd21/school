namespace Project3.Models;

// The ResourcesViewModel class is a model class that represents the data that will be displayed on the Resources page.
public class ResourcesViewModel
{
  public required string Title { get; set; }
  public required string SubTitle { get; set; }
  public required StudyAbroad StudyAbroad { get; set; }
  public required StudentServices StudentServices { get; set; }
  public required TutorsAndLabInformation TutorsAndLabInformation { get; set; }
  public required StudentAmbassadors StudentAmbassadors { get; set; }
  public required Forms Forms { get; set; }
  public required CoopEnrollment CoopEnrollment { get; set; }
}

public class StudyAbroad
{
  public required string Title { get; set; }
  public required string Description { get; set; }
  public required List<Place> Places { get; set; }
}

public class Place
{
  public required string NameOfPlace { get; set; }
  public required string Description { get; set; }
}

public class StudentServices
{
  public required string Title { get; set; }
  public required AcademicAdvisors AcademicAdvisors { get; set; }
  public required ProfessonalAdvisors ProfessonalAdvisors { get; set; }
  public required FacultyAdvisors FacultyAdvisors { get; set; }
  public required IstMinorAdvising IstMinorAdvising { get; set; }
}

public class AcademicAdvisors
{
  public required string Title { get; set; }
  public required string Description { get; set; }
  public required Faq Faq { get; set; }
}

public class Faq
{
  public required string Title { get; set; }
  public required string ContentHref { get; set; }
}

public class ProfessonalAdvisors
{
  public required string Title { get; set; }
  public required List<AdvisorInformation> AdvisorInformation { get; set; }
}

public class AdvisorInformation
{
  public required string Name { get; set; }
  public required string Department { get; set; }
  public required string Email { get; set; }
}

public class FacultyAdvisors
{
  public required string Title { get; set; }
  public required string Description { get; set; }
}

public class IstMinorAdvising
{
  public required string Title { get; set; }
  public required List<MinorAdvisorInformation> MinorAdvisorInformation { get; set; }
}

public class MinorAdvisorInformation
{
  public required string Title { get; set; }
  public required string Advisor { get; set; }
  public required string Email { get; set; }
}

public class TutorsAndLabInformation
{
  public required string Title { get; set; }
  public required string Description { get; set; }
  public required string TutoringLabHoursLink { get; set; }
}

public class StudentAmbassadors
{
  public required string Title { get; set; }
  public required string AmbassadorsImageSource { get; set; }
  public required List<SubSectionContent> SubSectionContent { get; set; }
  public required string ApplicationFormLink { get; set; }
  public required string Note { get; set; }
}

public class SubSectionContent
{
  public required string Title { get; set; }
  public required string Description { get; set; }
}

public class Forms
{
  public required List<GraduateForm> GraduateForms { get; set; }
  public required List<UndergraduateForm> UndergraduateForms { get; set; }
}

public class GraduateForm
{
  public required string FormName { get; set; }
  public required string Href { get; set; }
}

public class UndergraduateForm
{
  public required string FormName { get; set; }
  public required string Href { get; set; }
}

public class CoopEnrollment
{
  public required string Title { get; set; }
  public required List<EnrollmentInformationContent> EnrollmentInformationContent { get; set; }
  public required string RITJobZoneGuidelink { get; set; }
}

public class EnrollmentInformationContent
{
  public required string Title { get; set; }
  public required string Description { get; set; }
}