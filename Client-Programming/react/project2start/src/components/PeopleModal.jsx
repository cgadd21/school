import * as React from 'react';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';

const style = {
  position: 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 400,
  bgcolor: 'background.paper',
  border: '2px solid #000',
  boxShadow: 24,
  p: 4,
};

export const PeopleModal = (props) => {
  const [open, setOpen] = React.useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  return (
    <div>
      <Button onClick={handleOpen}>{props.name}</Button>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
          <Typography variant="h6" component="h2">
            {props.name}
          </Typography>
          <Typography variant="h6" component="h2">
            {props.tagline}
          </Typography>
          <Typography variant="h6" component="h2">
            {props.title}
          </Typography>
          <Typography variant="h6" component="h2">
            <img src={props.imagePath} alt="person" />
          </Typography>
          {props.website && (
            <Typography variant="h6" component="h2">
              Website: <a href={props.website}>{props.website}</a>
            </Typography>
          )}
        </Box>
      </Modal>
    </div>
  );
};
