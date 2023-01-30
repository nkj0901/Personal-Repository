import Card from "../ui/Card";

import Classes from "./NewMeetupForm.module.css"

function NewMeetupForm() {

    function submitHandler(event){
        event.preventDefault();


    }

    return (
      <Card>
        <form className={Classes.form} onSubmit={submitHandler}>
          <div className={Classes.control}>
            <label htmlFor="title">Meetup Title</label>
            <input type="text" required id="title" />
          </div>
          <div className={Classes.control}>
            <label htmlFor="image">Meetup Image</label>
            <input type="url" required id="image" />
          </div>
          <div className={Classes.control}>
            <label htmlFor="address">Address</label>
            <input type="text" required id="address" />
          </div>
          <div className={Classes.control}>
            <label htmlFor="description">Description</label>
            <textarea required id="description" rows="5" />
          </div>
          <div className={Classes.actions}>
            <button>Add Meetup</button>
          </div>
        </form>
      </Card>
    );
}

export default NewMeetupForm;