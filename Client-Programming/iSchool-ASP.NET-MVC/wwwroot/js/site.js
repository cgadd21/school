$(function () {
  $('#About').hide().fadeIn(2000);

  $('#Course').hide().fadeIn(2000);

  $('#Courses').hide().fadeIn(2000);
  $('#CoursesDegree').accordion({
    heightStyle: 'content',
    active: false,
    collapsible: true,
  });

  $('#Degrees').hide().fadeIn(2000);
  $('#UndergraduateDegrees').accordion({
    heightStyle: 'content',
    active: false,
    collapsible: true,
  });
  $('#GraduateDegrees').accordion({
    heightStyle: 'content',
    active: false,
    collapsible: true,
  });

  $('#Employments').hide().fadeIn(2000);
  $('#Employment').tabs();
  $('#CT').DataTable();
  $('#ET').DataTable();

  // used for loading partial view in the footer
  $('#Footers').load('/Home/Footer');
  $('#Footer').hide().fadeIn(2000);

  $('#Index h1').textillate({
    in: { effect: 'rollIn' },
    out: { effect: 'hinge', sync: true },
    loop: true,
  });

  $('#Minors').hide().fadeIn(2000);
  $('#UndergraduateMinors').accordion({
    heightStyle: 'content',
    active: false,
    collapsible: true,
  });

  $('#News').hide().fadeIn(2000);

  $('#Peoples').hide().fadeIn(2000);
  $('#People').tabs();

  $('#Researchs').hide().fadeIn(2000);
  $('#Research').accordion({
    heightStyle: 'content',
    active: false,
    collapsible: true,
  });

  $('#Resources').hide().fadeIn(2000);
  $('#Resource').tabs();
});
