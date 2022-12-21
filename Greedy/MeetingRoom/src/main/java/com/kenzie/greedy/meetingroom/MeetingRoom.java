package com.kenzie.greedy.meetingroom;

import java.security.KeyStore;
import java.util.*;

/**
 * Contains a problem that can be solved using the Greedy Technique.
 */
public class MeetingRoom {

    /**
     * You have a single meeting room for holding meetings. Given a list of meetings with start and end times,
     * return the maximum number of meetings that the meeting room can accommodate. Assume that all the meetings
     * are for the same day.
     *
     * Example: [(meetingName, startTime-endTime)]
     * meetings = [(meeting1, 13-14), (meeting2, 15-16), (meeting3, 8-12), (meeting4, 11-12),
     * (meeting5, 9-11), (meeting6, 14-16)]
     *
     * result = [(meeting5, 9-11),(meeting4, 11-12),(meeting1, 13-14),(meeting2, 15-16)] -> 4 meetings
     *
     * @param meetings - the list of possible meetings that can be scheduled
     * @return the maximum number of meetings that can be accommodated
     */
    public static int getMaximumMeetings(List<Meeting> meetings) {
        Map<Integer, Meeting> meetingsMap = new HashMap<Integer, Meeting>();

        for (Meeting meeting : meetings) {
            meetingsMap.put(meeting.getStartTime(), meeting);
        }
        TreeMap<Integer, Meeting> sortedMeetings = new TreeMap<>(meetingsMap);

        ArrayList<Meeting> maxMeetings = new ArrayList<>();

        sortedMeetings.entrySet()
                .forEach(x -> {
                    if (maxMeetings.size() == 0) {
                        maxMeetings.add(x.getValue());
                    } else if (x.getKey() >= maxMeetings.get(maxMeetings.size()-1).getEndTime()) {
                        maxMeetings.add(x.getValue());
                    }
                });

        return maxMeetings.size();
    }
}
