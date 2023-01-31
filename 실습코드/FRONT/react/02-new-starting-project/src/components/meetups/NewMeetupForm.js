import Card from "../ui/Card";
import { useRef } from 'react';

import Classes from "./NewMeetupForm.module.css"

function NewMeetupForm(props) {
  const titleInputRef = useRef();
  const imageInputRef = useRef();
  const addressInputRef = useRef();
  const descriptionInputRef = useRef();

  function submitHandler(event) {
    event.preventDefault();
    const enteredTitle = titleInputRef.current.value;
    const enteredImage = imageInputRef.current.value;
    const enteredAddress = addressInputRef.current.value;
    const enteredDecription = descriptionInputRef.current.value;

    //객체 만들기
    const meetupData = {
      title: enteredTitle,
      image: enteredImage,
      address: enteredAddress,
      description: enteredDecription
    };

    props.onAddMeetup(meetupData);
  }

  return (
    <Card>
      <form className={Classes.form} onSubmit={submitHandler}>
        <div className={Classes.control}>
          <label htmlFor="title">Meetup Title</label>
          <input type="text" required id="title" ref={titleInputRef} />
        </div>
        <div className={Classes.control}>
          <label htmlFor="image">Meetup Image</label>
          <input type="url" required id="image" ref={imageInputRef} />
        </div>
        <div className={Classes.control}>
          <label htmlFor="address">Address</label>
          <input type="text" required id="address" ref={addressInputRef} />
        </div>
        <div className={Classes.control}>
          <label htmlFor="description">Description</label>
          <textarea required id="description" rows="5" ref={descriptionInputRef} />
        </div>
        <div className={Classes.actions}>
          <button>Add Meetup</button>
        </div>
      </form>
    </Card>
  );
}

export default NewMeetupForm;