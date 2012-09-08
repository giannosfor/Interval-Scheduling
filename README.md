The manager of a large student union on campus comes to you with the
following problem. She’s in charge of a group of n students, each of whom
is scheduled to work one shift during the week. There are different jobs
associated with these shifts (tending the main desk, helping with package
delivery, rebooting cranky information kiosks, etc.), but.we can view each
shift as a single contiguous interval of time. There can be multiple shifts
going on at once.
She’s trying to choose a subset of these n students to form a super-
vising committee that she can meet with once a week. She considers such
a committee to be complete if, for every student not on the committee,
that student’s shift overlaps (at least partially) the shift of some student
who is on the committee. In this way, each student’s performance can be
observed by at least one person who’s serving on the committee.
Give an efficient algorithm that takes the schedule of n shifts and
produces a complete supervising committee containing as few students
as possible.
Example. Suppose n = 3, and the shifts are
Monday 4 p.M.-Monday 8 P.M.,
Monday 6 p.M.-Monday 10 P.M.,
Monday 9 P.M.-Monday 1I P.M..
Then the smallest complete supervising committee would consist of just
the second student, since the second shift overlaps both the first and the
third.


Algorithm Design by Jon Kleinberg and Éva Tardos