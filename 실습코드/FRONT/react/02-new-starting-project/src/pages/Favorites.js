import { useContect, useEffect } from 'react';

import FavoritesContext from '../store/favorites-context';

function FavoritesPage() {

  const favoritesCtx = useContect(FavoritesContext);


  return <div>FavoritesPage</div>;
}
export default FavoritesPage;
