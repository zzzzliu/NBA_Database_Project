select t.name, g.gameDate, p.win, p.home, ts.*
from Team t, Game g, Participation p, TeamStatisticsAGame ts
where t.id = p.isParticipatedBy and p.participates = g.id and t.name = "Atlanta Hawks"
and ts.partOfTeam = p.isParticipatedBy and ts.partOfGame = p.participates