import { useState, useEffect } from 'react'

import MeetupList from "../components/meetups/MeetupList";

function AllmeetupsPage() {
  const [isLoading, setIsLoading] = useState(true);
  const [loadingMeetups, setLoadedMeetups] = useState([]);

  useEffect(() => {
    fetch(
      "https://react-getting-started-27048-default-rtdb.firebaseio.com/meetups.json"
    ).then((response) => {
      return response.json();
    }).then((data) => {
      const meetups = [];

      for (const key in data) {
        const meetup = {
          id: key,
          ...data[key]
        };
        meetups.push(meetup)
        console.log(meetup)
      }
      setIsLoading(false);
      setLoadedMeetups(meetups);
    });
  }, []);

  if (isLoading) {
    <section>
      <p>Loading...</p>
    </section>
  }

  return <section>
    <h1>All Meetups</h1>
    <ul>
      <MeetupList meetups={loadingMeetups}></MeetupList>
    </ul>
  </section>
}
export default AllmeetupsPage;
